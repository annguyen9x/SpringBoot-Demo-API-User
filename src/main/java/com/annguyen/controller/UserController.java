package com.annguyen.controller;

import com.annguyen.entity.User;
import com.annguyen.model.dto.UserDto;
import com.annguyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Request nhận dưới dạng Http, đây là API sẽ trả response dạng: json, html, xml..
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Nếu không định nghĩa HttpMethod thì method này sẽ nhận xử lý tất cả các request của mọi
    //phương thức(GET, POST, DELETE, PUT,..) chỉ cần đúng đường dẫn
    //Có thể dùng @GetMapping("/hello-world") để không cần k/báo method
    @RequestMapping( value={""}, method = RequestMethod.GET)
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userService.getListUser();

        return ResponseEntity.status(HttpStatus.OK).body(users);
        //ResponseEntity trả về Httpstatus(tùy chọn: 500, 404,...) và Body ( dạng: json, xml, html,...)
    }

    @GetMapping("/{id}")
    //1. {id} là "tham số đường dẫn (path)"-PathVariable(tham số có thể thay đổi),
    //Nếu "tên tham số của hàm" (@PathVariable int idABC) khác "tên biến trên URL {id}"
    //(Khi đó Spring Boot không thực hiện ByDing được)
    // thì cần đặt tên biến trên URL trong @PathVariable("tên biến trên URL {id}") để sử dụng
    //2. Thức tự các Param của hàm không cần theo thứ tự các biến trên URL
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto user = userService.getUserById(id);

        return ResponseEntity.ok(user);
        //ResponseEntity trả về Httpstatus(chỉ status OKE) và Body ( dạng: json, xml, html,...)
    }

    @GetMapping("/search")
    //1. Mặc định thì "tên tham số truyền vào" phải đúng với "tên tham số của hàm",
    //nếu "tên t/số truyền vào" khác "tên t/so của hàm" thì cần đặt "tên t/số truyền vào" trong
    //@RequestParam("Tên t/số truyên vào, vd:ten") String keyword
    //2. "required = false" trong @RequestParam(required = false) String keyword
    // thì tham số truyền vào là không bắt buộc, mặc định là bắt buộc nếu không truyền tham số vào sẽ lối,
    //Nên đặt giá trị mặc định cho TH không truyền t/số vào để không bị lỗi khi xử lý ở Service bằng: defaultValue = ""
    public ResponseEntity<?> searchUser(@RequestParam(required = false, defaultValue = "") String keyword){
        System.out.println(keyword);
        List<UserDto> users = userService.searchUsers(keyword);

        return ResponseEntity.ok(users);
        //ResponseEntity trả về Httpstatus(chỉ status OKE:500) và Body ( dạng: json, xml, html,...)
    }

    //Post là request của hàm thêm
    @PostMapping("")
    public ResponseEntity<?> createUser(){
        return null;
    }

    //Put là request của hàm sửa
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(){
        return null;
    }

    //Delete là request của hàm xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(){
        return null;
    }
}
