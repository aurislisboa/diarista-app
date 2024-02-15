package com.development.diaristas.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.development.diaristas.core.enums.Icone;
import com.development.diaristas.core.models.Servico;
import com.development.diaristas.core.repositories.ServicoRepository;
import com.development.diaristas.web.dtos.ServicoForm;
import com.development.diaristas.web.mappers.WebServicoMapper;

import jakarta.validation.Valid;

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
    
    @Autowired
    private WebServicoMapper mapper;


    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }


    
    @GetMapping
    public ModelAndView buscarTodos() {
        var modelAndView = new ModelAndView("admin/servico/lista");

        modelAndView.addObject("servicos", repository.findAll());

        return modelAndView;
    }


    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelAndView = new ModelAndView("/admin/servico/form");
        
        modelAndView.addObject("form", new ServicoForm());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("form") ServicoForm form, BindingResult result) {
        
        if (result.hasErrors()) {
            return "admin/servico/form";
        }
        
        var servico = mapper.toModel(form);
        repository.save(servico);

        return "redirect:/admin/servicos";
    }


    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelAndView = new ModelAndView("admin/servico/form");

        var servico = repository.getReferenceById(id);
        var form = mapper.toForm(servico);

        modelAndView.addObject("form", form);
       
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid @ModelAttribute("form") ServicoForm form, BindingResult result) {

        System.out.println("_______________________________\n\n" + form);

        if (result.hasErrors()) {
            return "admin/servico/form";
        }

        var servico = mapper.toModel(form);
            servico.setId(id);

        repository.save(servico);
        
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        
        return "redirect:/admin/servicos";
    }
    


}





/*
 
@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoRepository repository;
     

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }


    
    @GetMapping
    public ModelAndView buscarTodos() {
        var modelAndView = new ModelAndView("admin/servico/lista");

        modelAndView.addObject("servicos", repository.findAll());

        return modelAndView;
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


    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelAndView = new ModelAndView("admin/servico/form");
        modelAndView.addObject("servico", repository.getReferenceById(id));
       
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Servico servico) {
        repository.save(servico);
        
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        
        return "redirect:/admin/servicos";
    }
    


}

 
 */