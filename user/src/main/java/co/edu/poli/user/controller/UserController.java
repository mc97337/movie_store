package co.edu.poli.user.controller;

import co.edu.poli.commons.helper.Response;
import co.edu.poli.commons.helper.ResponseBuild;
import co.edu.poli.user.persistence.entity.User;
import co.edu.poli.user.service.UserService;
import co.edu.poli.user.service.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll(){
        return builder.success(userService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody UserDTO userDTO, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        userService.save(userDTO);
        return builder.success(userDTO);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        User user = (User)  findById(id).getData();
        if(user==null){
            return builder.failed("Not found");
        }
        userService.delete(user);
        return builder.success(user);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return builder.success(userService.findById(id));
    }
    private List<Map<String, String>> formatMessage(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}
