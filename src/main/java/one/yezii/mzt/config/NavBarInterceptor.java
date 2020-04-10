package one.yezii.mzt.config;

import one.yezii.mzt.common.NavBarItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//该拦截器用于处理导航栏的显示样式，调用NavBarItem类来渲染导航栏
public class NavBarInterceptor implements HandlerInterceptor {


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String route = request.getServletPath();
        NavBarItem current;
        if (route.equals("/")) {
            current = NavBarItem.HOME;
        } else if (route.startsWith("/diary") || route.startsWith("/user")) {
            current = NavBarItem.DIARY;
        } else if (route.startsWith("/mzt")) {
            current = NavBarItem.MZT;
        } else {
            current = NavBarItem.ABOUT;
        }
        modelAndView.addObject("navBarItems", NavBarItem.listOfCurrent(current));
        modelAndView.setStatus(HttpStatus.OK);
    }


}
