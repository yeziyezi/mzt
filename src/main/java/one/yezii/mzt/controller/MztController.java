package one.yezii.mzt.controller;


import one.yezii.mzt.bean.MztCover;
import one.yezii.mzt.common.Pagination;
import one.yezii.mzt.data.entity.Mzt;
import one.yezii.mzt.service.MztService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static one.yezii.mzt.common.ResponsePage.ERROR_400;
import static one.yezii.mzt.common.ResponsePage.ERROR_404;

@Controller
@RequestMapping("/")
public class MztController {

    private final MztService mztService;

    public MztController(MztService mztService) {
        this.mztService = mztService;
    }

    //分页单图
    @GetMapping("/s/p/{page}")
    public String singles(Model model, @PathVariable Integer page) {
        if (page == null || page <= 0) {
            return ERROR_400;
        }
        List<Mzt> singles = mztService.getSingles(page, Pagination.DEFAULT_PAGE_SIZE);
        if (singles.isEmpty()) {
            return ERROR_404;
        }
        Optional<Pagination> pagination =
                Pagination.defaultPagination(page, mztService.singleAmount(), p -> "/s/p/" + p);
        if (pagination.isEmpty()) {
            return ERROR_404;
        }
        model.addAttribute("singles", singles);
        model.addAttribute("pagination", pagination.get());
        return "mzt/single";
    }

    //mzt首页
    @GetMapping("")
    public String mztIndex(Model model) {
        return "mzt/home";
    }

    //分页图集封面列表
    @GetMapping("/c/p/{page}")
    public String covers(Model model, @PathVariable Integer page) {
        if (page == null || page <= 0) {
            return ERROR_400;
        }
        List<MztCover> covers = mztService.getCovers(page, Pagination.DEFAULT_PAGE_SIZE);
        if (covers.isEmpty()) {
            return ERROR_404;
        }
        Optional<Pagination> pagination =
                Pagination.defaultPagination(page, mztService.collectionAmount(), p -> "/c/p/" + p);
        if (pagination.isEmpty()) {
            return ERROR_404;
        }
        model.addAttribute("covers", covers)
                .addAttribute("pagination", pagination.get());
        return "mzt/covers";
    }

    //浏览图集内容
    @GetMapping("/c/{collectionId}")
    public String collectionContent(Model model, @PathVariable String collectionId) {
        List<Mzt> mzts = mztService.getMztOfCollection(collectionId);
        if (mzts.isEmpty()) {
            return ERROR_404;
        }
        model.addAttribute("mztEntities", mzts);
        return "mzt/collection";
    }
}
