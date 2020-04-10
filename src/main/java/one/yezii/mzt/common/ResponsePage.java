package one.yezii.mzt.common;

import org.springframework.ui.Model;

public interface ResponsePage {
    String ERROR_404 = "redirect:/errorPage/404";
    String ERROR_400 = "redirect:/errorPage/400";
    String COMMON_ERROR = "error/common_error";

    static String setCommonErrorModel(Model model, String message, String fromUrl) {
        model.addAllAttributes(new Result().set("message", message).set("fromUrl", fromUrl));
        return COMMON_ERROR;
    }
}
