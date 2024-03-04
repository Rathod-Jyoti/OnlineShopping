package com.cnc.ecart.Controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cnc.ecart.GenericResponse;
import com.cnc.ecart.model.Category;
import com.cnc.ecart.service.CategoryService;

@RestController
@RequestMapping("category")
@CrossOrigin(" http://localhost:4200")
public class CategoryController
{
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("add")
	public GenericResponse<Category> addCategory(@RequestParam  String catName,
			@RequestParam String catDesc,@RequestParam String status,
			@RequestParam Integer mainCatId,@RequestParam MultipartFile catImage)throws IOException
	{
		Category category = new Category();
		if(catImage!=null)
		{
			category.setCatImg(Base64.getEncoder().encodeToString(catImage.getBytes()));
			category.setImageName(catImage.getOriginalFilename());
		}
		category.setCatName(catName);
		category.setCatDesc(catDesc);
		category.setStatus(status);
		category.setMainCatId(mainCatId);
		Category response = categoryService.addCategory(category);
		if(response!=null)
		{
			return GenericResponse.<Category>builder().success(true).data(response).message("").build();
			//return new GenericResponse<Category>(true,reponse,"Category added successfully...!");
		}
		else
		{
			return GenericResponse.<Category>builder().success(true).data(response).message("").build();
		}
	}
	
			@GetMapping("remove-category/{catId}")
	    public String removeCategory(@PathVariable("catId")int catId) {
		if(categoryService.removeCategory(catId)) {
			return "success";
		}
		else {
			return "unsuccess";
		}
	}
	
	@GetMapping("/all")
	public List<Category> getCategories(){
	return	categoryService.getCategories();
	 
	}
	@GetMapping("by-id/{catId}")
	public Category getCategory(@PathVariable("catId")int catId) {
		return categoryService.getCategory(catId);
	}
	@GetMapping("by-ref-id/{mainCatId}")
	public List<Category> getProductsByCat(@PathVariable("mainCatId")int mainCatId)
	{
		List<Category> category = categoryService.getCategoriesByMainCatId(mainCatId);
		if(response!=null)
		{
			return category;
		}
		else
		{
			return null;
		}
	}

}
