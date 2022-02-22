package com.ensolversdemoproj.demoproj.Controllers;

import java.net.URI;
import java.util.List;

import com.ensolversdemoproj.demoproj.DTO.FolderCreationDto;
import com.ensolversdemoproj.demoproj.DTO.FolderDto;
import com.ensolversdemoproj.demoproj.DTO.FolderUpdateDto;
import com.ensolversdemoproj.demoproj.DTO.ItemDto;
import com.ensolversdemoproj.demoproj.Services.FolderService;

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
@RequestMapping("/api/folder")
public class FolderController {
    @Autowired
	private FolderService folderService;

    @PostMapping
	private ResponseEntity<FolderDto> guardar(@RequestBody FolderCreationDto folderDTO) {
		try 
        {
		    FolderDto folderCreated = folderService.create(folderDTO);
			return ResponseEntity.created(new URI("api/folder" + folderCreated)).body(folderCreated);
			
		} 
        catch (Exception e) 
        {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

    @GetMapping(value = "{id}")
	private ResponseEntity<FolderDto> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(folderService.findById(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

    @GetMapping(value = "/items/{id}")
	private ResponseEntity<List<ItemDto>> getItemsById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(folderService.getAllItems(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	private ResponseEntity<List<FolderDto>> getAll() {
		try {
			return ResponseEntity.ok(folderService.findAll());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "{id}")
	private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			folderService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(value = "{id}")
	private ResponseEntity<FolderUpdateDto> update(@RequestBody FolderUpdateDto folderDto,
			@PathVariable("id") Long id) {
		try {
			FolderUpdateDto updatedFolder = folderService.update(folderDto, id);
			ResponseEntity.ok().build();
			return ResponseEntity.ok(updatedFolder);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
    
}