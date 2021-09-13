package com.test.demo.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.test.demo.bo.PageCounter;
import com.test.demo.dto.PersonDTO;
import com.test.demo.exception.http.NotFoundException;
import com.test.demo.model.Banner;
import com.test.demo.model.Spu;
import com.test.demo.sample.IConnect;
import com.test.demo.service.BannerServiceImpl;
import com.test.demo.service.SpuService;
import com.test.demo.util.CommonUtil;
import com.test.demo.vo.PagingDozer;
import com.test.demo.vo.SpuSimplifyVO;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
//@Lazy
@RequestMapping("/spu")
@Validated
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id){
        Spu spu = this.spuService.getSpu(id);
        if(spu == null){
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVO getSimplifySpu(@PathVariable @Positive(message="{id.positive}") Long id){
        Spu spu = this.spuService.getSpu(id);
        SpuSimplifyVO vo = new SpuSimplifyVO();
        BeanUtils.copyProperties(spu,vo);
        //vo.setTitle(spu.getTitle());
        return vo;
    };

    @GetMapping("/latest")

    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start, @RequestParam(defaultValue = "10") Integer count){
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start,count);
        Page<Spu> page = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);
//        Mapper mapper= DozerBeanMapperBuilder.buildDefault();
//        List<SpuSimplifyVO> vos = new ArrayList<>();
//        spuList.forEach(s->{
//            SpuSimplifyVO vo = mapper.map(s,SpuSimplifyVO.class);
//            vos.add(vo);
//        });
//        return vos;
    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu,SpuSimplifyVO> getByCategoryId(@PathVariable @Positive Long id,
                                                          @RequestParam(name = "is_root",defaultValue = "false") Boolean isRoot,
                                                          @RequestParam(name="start",defaultValue = "0") Integer start,
                                                          @RequestParam(name="count",defaultValue = "10") Integer count){
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getByCategory(id, isRoot, pageCounter.getPage(),pageCounter.getCount());
        return new PagingDozer<>(page,SpuSimplifyVO.class);

    }

}
