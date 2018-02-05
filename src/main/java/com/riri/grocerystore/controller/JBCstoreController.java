package com.riri.grocerystore.controller;

import com.riri.grocerystore.model.Cleaning;
import com.riri.grocerystore.model.Cosmetics;
import com.riri.grocerystore.model.Snacks;
import com.riri.grocerystore.repository.CleaningRepo;
import com.riri.grocerystore.repository.CosmeticsRepo;
import com.riri.grocerystore.repository.SnacksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class JBCstoreController {

    @Autowired
    CosmeticsRepo cosmeticsRepo;
    @Autowired
    CleaningRepo cleaningRepo;
    @Autowired
    SnacksRepo snacksRepo;

private double totalRevenue=0;

    @RequestMapping("/")
    public String listinventory(Model model) {
        return "redirect:/addcosmetics";
    }

    @GetMapping("/addcosmetics")
    public String cosmeticsForm(Model model){
        model.addAttribute("cosmetic",new Cosmetics());
        //Cosmetics c = new Cosmetics();
        return "cosmeticsform";
    }

    @PostMapping("/postcosmetics")
    public String processCosmeticsForm(@Valid @ModelAttribute("cosmetic") Cosmetics cosmetic,
                                      BindingResult result){
        if(result.hasErrors()){
            return "cosmeticsform";
        }
        cosmeticsRepo.save(cosmetic);
        totalRevenue += cosmetic.getTotal();
        return "redirect:/addcosmetics";

    }


    @GetMapping("/addcleaning")
    public String cleaningForm(Model model){
        model.addAttribute("cleaning",new Cleaning());
        return "cleaningform";
    }

    @PostMapping("/postcleaning")
    public String processCleaningForm(@Valid @ModelAttribute("cleaning") Cleaning cleaning,
                                      BindingResult result){
        if(result.hasErrors()){
            return "cleaningform";
        }
        cleaningRepo.save(cleaning);
        totalRevenue += cleaning.getTotal();
        return "redirect:/addcleaning";

    }


    @GetMapping("/addsnacks")
    public String snacksForm(Model model){
        model.addAttribute("snack",new Snacks());
        return "snacksform";
    }

    @PostMapping("/postsnacks")
    public String processSnacksForm(@Valid @ModelAttribute("snack") Snacks snack,
                                      BindingResult result){
        if(result.hasErrors()){
            return "snacksform";
        }
        snacksRepo.save(snack);
        totalRevenue += snack.getTotal();
        return "redirect:/addsnacks";

    }


    @GetMapping("/printinventory")
    public String printInventory(Model model){
        model.addAttribute("cosmetics", cosmeticsRepo.findAll());
        model.addAttribute("cleanings", cleaningRepo.findAll());
        model.addAttribute("snacks", snacksRepo.findAll());
        model.addAttribute("totalrev", totalRevenue);
        return "printinventory";
    }


}
