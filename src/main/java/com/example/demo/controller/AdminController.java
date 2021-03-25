package com.example.demo.controller;

import com.example.demo.exception.BadDataException;
import com.example.demo.models.realmodel.Atributs;
import com.example.demo.models.realmodel.Order;
import com.example.demo.models.realmodel.Product;
import com.example.demo.models.requests.SendEmail;
import com.example.demo.models.requests.forAdmin.AddAtrubut;
import com.example.demo.models.requests.forAdmin.UpdateAtributs;
import com.example.demo.models.requests.forAdmin.UpdateProduct;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.emailService.EmailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@PreAuthorize("hasRole('admin')")
@RequestMapping(value = "api/v1/admin/")
public class AdminController {
    private final ProductsRepository productsRepository;
    private final AdminService adminService;
    private final EmailService emailService;

    public AdminController(ProductsRepository productsRepository, AdminService adminService, EmailService emailService) {
        this.productsRepository = productsRepository;
        this.adminService = adminService;
        this.emailService = emailService;
    }


    @RequestMapping(value = "/send/email",method = RequestMethod.POST)
    public SendEmail sendEmail(@AuthenticationPrincipal UserDetails userDetails,@Valid @RequestBody SendEmail sendEmail){
        emailService.sendEmail(sendEmail.getTo(), sendEmail.getBody(), sendEmail.getTopic());
        return sendEmail;
    }


    @RequestMapping(value = "/products/list/{num}/{page}",method = RequestMethod.POST)
    public Page<Product> getProductList(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(name = "num")String num, @PathVariable(name="page")Integer page){
        System.out.println("shevida?");
        if(productsRepository.findAllByTitleLike(num, PageRequest.of(page,20))!=null){
            return productsRepository.findAllByTitleLike(num,PageRequest.of(page,20, Sort.by("title")));
        }
        System.out.println("shevidaaa");
        throw new BadDataException("araferia");
    }

    @RequestMapping(value = "/product/update",method = RequestMethod.POST)
    public Product updateProduct(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody @ModelAttribute UpdateProduct updateProduct) throws InterruptedException {
       Product product= adminService.updateProduct(updateProduct);
       Thread.sleep(1000);
       System.out.println(updateProduct.getMultiPartFile().getName());
       System.out.println("aqamde aketebs");
        System.out.print(updateProduct.getMultiPartFile().getName());
       return adminService.pictureUpdate(product,updateProduct.getMultiPartFile());
    }

    @RequestMapping(value = "/company/list",method = RequestMethod.POST)
    public List<Order> orderList(@AuthenticationPrincipal UserDetails userDetails){
      return  adminService.getOrderList();
    }

    @RequestMapping(value = "/create/atribut",method = RequestMethod.POST)
    public Atributs createAtribut(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody UpdateAtributs updateAtributs)
    {
        return adminService.createAtribut(updateAtributs);
    }

    @RequestMapping(value = "/delete/atribut/{name}",method = RequestMethod.DELETE)
    public String deleteAtribut(@AuthenticationPrincipal UserDetails userDetails,@PathVariable(name = "name")String name){
        adminService.deleteAtribut(name);
        return "deleted";
    }

    @RequestMapping(value = "/procuct/add/atribut",method = RequestMethod.POST)
    public Product addatribut(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody AddAtrubut addAtrubut){
      return   adminService.addAtribut(addAtrubut);
    }


    @RequestMapping(value = "/delete/order/{email}",method = RequestMethod.DELETE)
    public String deleteOrder(@AuthenticationPrincipal UserDetails userDetails,@PathVariable(name="email")String email){
        adminService.deleteOrder(email);
        return "deleted";
    }

    @RequestMapping(value = "/delete/product/{title}",method = RequestMethod.POST)
    public void deleteProduct(@AuthenticationPrincipal UserDetails userDetails,@PathVariable(name="title")String title){
        adminService.deleteProduct(title);
    }










}
