package com.example.MandelbrotSet.client;


import com.example.MandelbrotSet.service.MandelbrotSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class WebController {

 MandelbrotSet mds;

    @PostMapping("/dimension")
    public String createImage(@Valid @ModelAttribute FormBean FormBean, Model model){
            mds.renderMandelbrotSetFromInput(FormBean.min_x, FormBean.max_x, FormBean.min_y, FormBean.max_y);
            model.addAttribute("min_x", FormBean.getMin_x());
            model.addAttribute("max_x", FormBean.getMax_x());
            model.addAttribute("min_y", FormBean.getMin_y());
            model.addAttribute("max_y", FormBean.getMax_y());

            model.addAttribute("FormBean", new FormBean());
        return "dimension";
}
}
