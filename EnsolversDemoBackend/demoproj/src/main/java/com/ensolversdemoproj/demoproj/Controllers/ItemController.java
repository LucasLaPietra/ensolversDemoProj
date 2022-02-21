package com.ensolversdemoproj.demoproj.Controllers;

import java.net.URI;
import java.util.List;

import com.ensolversdemoproj.demoproj.DTO.ItemCreationDto;
import com.ensolversdemoproj.demoproj.DTO.ItemDto;
import com.ensolversdemoproj.demoproj.DTO.ItemUpdateDto;
import com.ensolversdemoproj.demoproj.Services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
	private ItemService itemService;

    @PostMapping
	private ResponseEntity<ItemCreationDto> guardar(@RequestBody ItemCreationDto itemDTO) {
		try 
        {
		    itemService.create(itemDTO);
			return ResponseEntity.created(new URI("api/item" + itemDTO)).body(itemDTO);
			
		} 
        catch (Exception e) 
        {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

    @GetMapping(value = "{id}")
	private ResponseEntity<ItemDto> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(itemService.findById(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping
	private ResponseEntity<List<ItemDto>> getAll() {
		try {
			return ResponseEntity.ok(itemService.findAll());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "{id}")
	private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			itemService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(value = "{id}")
	private ResponseEntity<ItemUpdateDto> update(@RequestBody ItemUpdateDto itemDto,
			@PathVariable("id") Long id) {
		try {
			ItemUpdateDto updatedItem = itemService.update(itemDto, id);
			ResponseEntity.ok().build();
			return ResponseEntity.ok(updatedItem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
    
}
