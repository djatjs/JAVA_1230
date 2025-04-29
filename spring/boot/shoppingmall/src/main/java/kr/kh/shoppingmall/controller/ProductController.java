package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;


    @GetMapping("/list/{ca_num}")
    public String list(@PathVariable int ca_num, Model model) {
        List<ProductVO> productList = productService.getProductList(ca_num);
        model.addAttribute("productList", productList);
        return "product/list";
    }
    
    
    
}
