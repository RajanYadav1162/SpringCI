package com.rajan.springCI.controllers;

import com.rajan.springCI.model.DataObject;
import com.rajan.springCI.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

  @Autowired
  private DataRepository dataRepository;

  @GetMapping
  public String test(Model model) {
    model.addAttribute("dataObject", new DataObject());
    model.addAttribute("data", dataRepository.getDataObjects());
    model.addAttribute("delete", new DataObject());
    return "index";
  }

  @PostMapping("/send-data")
  public String formSubmitRequest(@ModelAttribute("dataObject") DataObject dataObject) {
    dataRepository.addData(dataObject);
    return "redirect:/";
  }

  @PostMapping("/delete-data")
  public String deleteTodo(@ModelAttribute("delete") DataObject dataObject) {
    dataRepository.deleteData(dataObject.getData());
    return "redirect:/";
  }
}
