package com.insta.humanoid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ui.Model;
@Data
@AllArgsConstructor
public class CustomModel {
    private String path;
    private Model model;
}
