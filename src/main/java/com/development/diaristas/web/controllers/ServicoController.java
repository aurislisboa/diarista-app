package com.development.diaristas.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.development.diaristas.core.enums.Icone;
import com.development.diaristas.core.models.Servico;
import com.development.diaristas.core.repositories.ServicoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoRepository repository;


    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }


    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelAndView = new ModelAndView("/admin/servico/form");
        
        modelAndView.addObject("servico", new Servico());
        // modelAndView.addObject("icones", Icone.values());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Servico servico) {
        repository.save(servico);

        return "redirect:/admin/servicos";
    }


    @GetMapping
    public ModelAndView buscarTodos() {
        var modelAndView = new ModelAndView("admin/servico/lista");

        modelAndView.addObject("servicos", repository.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        
        return "redirect:/admin/servicos";
    }
    


}
