package com.example.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;

}
