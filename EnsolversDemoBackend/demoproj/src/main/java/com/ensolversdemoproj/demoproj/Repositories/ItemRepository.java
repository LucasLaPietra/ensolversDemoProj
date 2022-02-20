package com.ensolversdemoproj.demoproj.Repositories;

import com.ensolversdemoproj.demoproj.Model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
