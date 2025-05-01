package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.shoppingmall.model.vo.BuyVO;
import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.service.ProductService;
import kr.kh.shoppingmall.utils.CustomUser;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    
    @GetMapping("/detail")
    public String getMethodName(String pr_code, Model model) {
        System.out.println(pr_code);
        ProductVO product = productService.getProduct(pr_code, false);
        model.addAttribute("product", product);
        return "product/detail";
    }
    
    @PostMapping("/amount/check")
    @ResponseBody
    public int amountCheck(@RequestParam String code) {
        ProductVO product = productService.getProduct(code, false);
        return product.getPr_amount();
    }
    
    @PostMapping("/buy")
    public String buy(BuyVO buy, @AuthenticationPrincipal CustomUser customUser, HttpServletRequest request, Model model) {
        String prevUrl = request.getHeader("Referer");
        if(productService.buy(buy, customUser)){
            return "redirect:/product/buy/complete/"+ buy.getBu_num();
        }
        //실패하면 이전 URL로
        return "redirect:/"+prevUrl;
    }
    
    @GetMapping("/buy/complete/{bu_num}")
    public String buyComplete(@PathVariable int bu_num) {
        return "product/complete";
    }
    
    
    
    
}
