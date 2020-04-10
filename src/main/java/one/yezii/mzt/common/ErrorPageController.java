package one.yezii.mzt.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public Result handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return Result.error(ResponseCode.ofCode(statusCode));
    }

    @RequestMapping("/errorPage/{statusCode}")
    public String errorPage(Model model, @PathVariable Integer statusCode, String fromUrl) {
        ResponseCode responseCode = ResponseCode.ofCode(statusCode);
        model.addAttribute("message", responseCode.getCode() + " " + responseCode.getMessage());
        model.addAttribute("fromUrl", fromUrl);
        return "error/common_error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


}