package com.example.laba2.controller;

import com.example.laba2.entity.Petition;
import com.example.laba2.service.PetitionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/petition")
public class PetitionController {

    private final PetitionService petitionService;

    @GetMapping
    public String getAll(Model model) {
        List<Petition> petitions = this.petitionService.findAll();

        model.addAttribute("petitions", petitions);

        return "petition";
    }

    @PostMapping
    public void create(@Valid @RequestBody Petition petition) {
        this.petitionService.create(petition);
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable Long id) {
        this.petitionService.delete(id);
    }

}
