package ru.gb.lesson3.homework;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final Cart cart;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String showProductById(Model model,
                                  @PathVariable Integer id) {
        Product productById = cart.getProductById(id);
        if (productById == null) {
            productById = new Product(cart.products.size(), "", 0);
        }
        model.addAttribute("product", productById);
        return "create-product";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String createProduct(Model model) {

        Product productById = new Product(cart.products.size(), "", 0);

        model.addAttribute("product", productById);
        return "create-product";
    }

    // обработчик формы создания и редактирования, /message/edit/{id}
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        product.id = cart.products.size();
        cart.addProduct(product);
        return "redirect:/cart/all"; // ключевое слово перенаправления
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProduct(Model model) {
        model.addAttribute("products", cart.allProducts());
        return "product-list";
    }
}
