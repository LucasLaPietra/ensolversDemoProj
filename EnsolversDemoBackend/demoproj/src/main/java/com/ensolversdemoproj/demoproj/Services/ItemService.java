package com.ensolversdemoproj.demoproj.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensolversdemoproj.demoproj.DTO.ItemCreationDto;
import com.ensolversdemoproj.demoproj.DTO.ItemDto;
import com.ensolversdemoproj.demoproj.DTO.ItemUpdateDto;
import com.ensolversdemoproj.demoproj.Model.Item;
import com.ensolversdemoproj.demoproj.Repositories.ItemRepository;


@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ItemCreationDto create(ItemCreationDto itemDto){
        Item item = modelMapper.map(itemDto, Item.class);
        item.setChecked(false);
        itemRepository.save(item);
        return modelMapper.map(item, ItemCreationDto.class);
    }

    public void delete(long idItem) {
        itemRepository.deleteById(idItem);
    }

    public ItemDto findById(long idItem) {
        Optional<Item> item = itemRepository.findById(idItem);
        if (item.isPresent()) {
            return modelMapper.map(item.get(), ItemDto.class);
        }
        else throw new NullPointerException();
    }

    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemDtos = new ArrayList<ItemDto>();
        for (Item item : items) 
        {
            ItemDto itemDto = modelMapper.map(item, ItemDto.class);
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }

    public ItemUpdateDto update(ItemUpdateDto itemDto, long idItem)
    {
        Optional<Item> item = itemRepository.findById(idItem);
        if (item.isPresent()) {
            Item presentItem = item.get();
            presentItem.setTitle(itemDto.getTitle());
            presentItem.setChecked(itemDto.isChecked());
            itemRepository.save(presentItem);
            return modelMapper.map(presentItem, ItemUpdateDto.class);
        }
        else throw new NullPointerException();
    }
    
}
