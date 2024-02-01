package com.example.kiemtra1.controller;

import com.example.kiemtra1.model.HomeStay;
import com.example.kiemtra1.repository.ICityRepository;
import com.example.kiemtra1.repository.IHomeStayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/homestay")
public class Controller {
    @Autowired
    ICityRepository iCityRepository;
    @Autowired
    IHomeStayRepository iHomeStayRepository;

    @GetMapping
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listHomeStay",iHomeStayRepository.findAll());
        modelAndView.addObject("listCity",iCityRepository.findAll());
        return modelAndView;
    }
    @GetMapping("/info/{id}")
    public ModelAndView infomation(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/infomation");
        modelAndView.addObject("listHomeStay",iHomeStayRepository.findById(id));
        modelAndView.addObject("listCity",iCityRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("/search");
        modelAndView.addObject("listHomeStay",iHomeStayRepository.findAllByNameContaining(name));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("listHomeStay", new HomeStay());
        modelAndView.addObject("CityCreate",iCityRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewCity(@Validated HomeStay homeStay, BindingResult bindingResult){
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
        iHomeStayRepository.save(homeStay);
        modelAndView = new ModelAndView("redirect:/homestay");
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView create(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("homeStayS",iHomeStayRepository.findById(id));
        modelAndView.addObject("id", id);
        modelAndView.addObject("listCity",iCityRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/remove")
    public ModelAndView remove(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/homestay");
        iHomeStayRepository.deleteById(id);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("HomeStays",iHomeStayRepository.findById(id));
        modelAndView.addObject("CityCreate",iCityRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam("id") int id, @Validated HomeStay homeStay, BindingResult bindingResult){
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/edit");
            return modelAndView;
        }
        iHomeStayRepository.save(homeStay);
        modelAndView = new ModelAndView("redirect:/homestay");
        return modelAndView;
    }

}
