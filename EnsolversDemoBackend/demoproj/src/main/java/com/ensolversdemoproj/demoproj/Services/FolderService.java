package com.ensolversdemoproj.demoproj.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ensolversdemoproj.demoproj.DTO.FolderCreationDto;
import com.ensolversdemoproj.demoproj.DTO.FolderDto;
import com.ensolversdemoproj.demoproj.DTO.FolderUpdateDto;
import com.ensolversdemoproj.demoproj.DTO.ItemDto;
import com.ensolversdemoproj.demoproj.Model.Folder;
import com.ensolversdemoproj.demoproj.Model.Item;
import com.ensolversdemoproj.demoproj.Repositories.FolderRepository;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ModelMapper modelMapper;

    public FolderDto create(FolderCreationDto folderDto){
        Folder folder = modelMapper.map(folderDto, Folder.class);
        Folder savedFolder = folderRepository.save(folder);
        return modelMapper.map(savedFolder, FolderDto.class);
    }

    public void delete(long idFolder) {
        Folder folder = folderRepository.findById(idFolder).get();
        for (Item item : folder.getItems()) 
        {
            itemService.delete(item.getIdItem());
        }
        folderRepository.deleteById(idFolder);
    }

    public FolderDto findById(long idFolder) {
        Optional<Folder> folder = folderRepository.findById(idFolder);
        if (folder.isPresent()) {
            return modelMapper.map(folder.get(), FolderDto.class);
        }
        else throw new NullPointerException();
    }

    public List<FolderDto> findAll() {
        List<Folder> folders = folderRepository.findAll();
        List<FolderDto> folderDtos = new ArrayList<FolderDto>();
        for (Folder folder : folders) 
        {
            FolderDto folderDto = modelMapper.map(folder, FolderDto.class);
            folderDtos.add(folderDto);
        }
        return folderDtos;
    }

    public List<ItemDto> getAllItems(long idFolder) {
        Optional<Folder> folder = folderRepository.findById(idFolder);
        List<ItemDto> itemDtos = new ArrayList<ItemDto>();
        if (folder.isPresent()) {
            for (Item item : folder.get().getItems()) 
            {
                ItemDto itemDto = modelMapper.map(item, ItemDto.class);
                itemDtos.add(itemDto);
            }
            return itemDtos;
        }
        else throw new NullPointerException();
    }

    public FolderUpdateDto update(FolderUpdateDto folderDto, long idFolder)
    {
        Optional<Folder> folder = folderRepository.findById(idFolder);
        if (folder.isPresent()) {
            Folder presentFolder = folder.get();
            presentFolder.setTitle(folderDto.getTitle());
            folderRepository.save(presentFolder);
            return modelMapper.map(presentFolder, FolderUpdateDto.class);
        }
        else throw new NullPointerException();
    }
}
