package com.springboot.techhub.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.techhub.dto.Brand_Master_Dto;
import com.springboot.techhub.dto.Category_Master_Dto;
import com.springboot.techhub.dto.Payment_Method_Dto;
import com.springboot.techhub.dto.Product_Master_Dto;
import com.springboot.techhub.model.Category_Master;
import com.springboot.techhub.model.Product_Master;
import com.springboot.techhub.repository.Product_Master_Repository;
import com.springboot.techhub.service.Brand_Master_Service;
import com.springboot.techhub.service.Category_Master_Service;
import com.springboot.techhub.service.Payment_Method_Service;
import com.springboot.techhub.service.Product_Master_Service;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Product_Master_Service product_Master_Service;
	
	@Autowired
	private Brand_Master_Service brand_Master_Service;
	
	@Autowired
	private Category_Master_Service category_Master_Service;

	@Autowired
	private Product_Master_Repository product_Master_Repository;

	@Autowired
	private Payment_Method_Service payment_Method_Service;

	public String cleanUpString(String input) {
        if (input != null) {
            // Replace commas with an appropriate alternative
            return input.replace(",,", "");
        }
        return input;
    }
	
	@GetMapping("/viewproduct")
	public String getViewProductPage(Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		try {
			// List <Product_Master> product_Masters=product_Master_Repository.findAll();
			model.addAttribute("Product_Master", product_Master_Service.getAllProduct_Masters());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "viewproduct";
	}

	@GetMapping("/addProduct")
	public String getAddProductPage(@ModelAttribute("product") Product_Master_Dto product_Master_Dto,Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		List<Category_Master> categories=category_Master_Service.listAllCategory();
		model.addAttribute("categories", categories);
		// Product_Master_Dto product_Master_Dto=new Product_Master_Dto();
		model.addAttribute("product", product_Master_Dto);
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String getAddProductForm(@Valid @ModelAttribute("product") Product_Master_Dto product_Master_Dto,BindingResult result,Model model,Principal principal) {
		// product_Master_Service.product_save(product_Master_Dto);
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		if (product_Master_Dto.getProduct_Image().isEmpty()) {
            result.addError(new FieldError("product_Master_Dto", "Product_Image", "The image file is required"));
        }
        if (result.hasErrors()) {
            return "addProduct";
        }

		MultipartFile image=product_Master_Dto.getProduct_Image();
        Date createdAt=new Date();
        String storageFileName=createdAt.getTime()+"_"+image.getOriginalFilename();
		try {
            String uploadDir="public/images/";
            Path uploadPath=Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputstream=image.getInputStream()) {
                Files.copy(inputstream, Paths.get(uploadDir+storageFileName),StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }

		Product_Master product_Master=new Product_Master();
		
		product_Master.setProduct_Image(storageFileName);
		product_Master.setcreatedAt(createdAt);
		product_Master.setProduct_name(product_Master_Dto.getProduct_name());
		product_Master.setProduct_Price(product_Master_Dto.getProduct_Price());
		product_Master.setManufacturer(product_Master_Dto.getManufacturer());
		product_Master.setSeries(product_Master_Dto.getSeries());
		product_Master.setColour(product_Master_Dto.getColour());
		product_Master.setForm_Factor(product_Master_Dto.getForm_Factor());
		product_Master.setProduct_Height(product_Master_Dto.getProduct_Height());
		product_Master.setProduct_Weight(product_Master_Dto.getProduct_Weight());
		product_Master.setProduct_Dimensions(product_Master_Dto.getProduct_Dimensions());
		product_Master.setIncluded_Components(product_Master_Dto.getIncluded_Components());
		product_Master.setCountry_of_Origin(product_Master_Dto.getCountry_of_Origin());
		product_Master.setProduct_Decscription(product_Master_Dto.getProduct_Decscription());
		product_Master.setProduct_Warranty(product_Master_Dto.getProduct_Warranty());
		product_Master.setStockquantity(product_Master_Dto.getStockquantity());

		if (product_Master_Dto.getStanding_screen_display_size().isEmpty() || product_Master_Dto.getStanding_screen_display_size().equals(",")) {
            product_Master.setStanding_screen_display_size(null);
        }
		else{
			product_Master.setStanding_screen_display_size(cleanUpString(product_Master_Dto.getStanding_screen_display_size()));
		}

		if (product_Master_Dto.getScreen_Resolution().isEmpty() || product_Master_Dto.getScreen_Resolution().equals(",")) {
            product_Master.setScreen_Resolution(null);
        }
		else{
			product_Master.setScreen_Resolution(cleanUpString(product_Master_Dto.getScreen_Resolution()));
		}

		if (product_Master_Dto.getBatteries().isEmpty() || product_Master_Dto.getBatteries().equals(",")) {
            product_Master.setBatteries(null);
        }
		else{
			product_Master.setBatteries(cleanUpString(product_Master_Dto.getBatteries()));
		}
		
		if (product_Master_Dto.getProcessor_Brand().isEmpty() || product_Master_Dto.getProcessor_Brand().equals(",")) {
            product_Master.setProcessor_Brand(null);
        }
		else{
			product_Master.setProcessor_Brand(cleanUpString(product_Master_Dto.getProcessor_Brand()));
		}
		
		if (product_Master_Dto.getProcessor_Type().isEmpty() || product_Master_Dto.getProcessor_Type().equals(",")) {
            product_Master.setProcessor_Type(null);
        }
		else{
			product_Master.setProcessor_Type(cleanUpString(product_Master_Dto.getProcessor_Type()));
		}

		if (product_Master_Dto.getProcessor_Speed().isEmpty() || product_Master_Dto.getProcessor_Speed().equals(",")) {
            product_Master.setProcessor_Speed(null);
        }
		else{
			product_Master.setProcessor_Speed(cleanUpString(product_Master_Dto.getProcessor_Speed()));
		}
		
		if (product_Master_Dto.getRAM_Size().isEmpty() || product_Master_Dto.getRAM_Size().equals(",")) {
            product_Master.setRAM_Size(null);
        }
		else{
			product_Master.setRAM_Size(cleanUpString(product_Master_Dto.getRAM_Size()));
		}
		
		if (product_Master_Dto.getMemory_Technology().isEmpty() || product_Master_Dto.getMemory_Technology().equals(",")) {
            product_Master.setMemory_Technology(null);
        }
		else{
			product_Master.setMemory_Technology(cleanUpString(product_Master_Dto.getMemory_Technology()));
		}

		if (product_Master_Dto.getMaximum_Memory_Supported().isEmpty() || product_Master_Dto.getMaximum_Memory_Supported().equals(",")) {
            product_Master.setMaximum_Memory_Supported(null);
        }
		else{
			product_Master.setMaximum_Memory_Supported(cleanUpString(product_Master_Dto.getMaximum_Memory_Supported()));
		}

		if (product_Master_Dto.getHard_Disk_Type_Description().isEmpty() || product_Master_Dto.getHard_Disk_Type_Description().equals(",")) {
            product_Master.setHard_Disk_Type_Description(null);
        }
		else{
			product_Master.setHard_Disk_Type_Description(cleanUpString(product_Master_Dto.getHard_Disk_Type_Description()));
		}

		if (product_Master_Dto.getAudio_Details().isEmpty() || product_Master_Dto.getAudio_Details().equals(",")) {
            product_Master.setAudio_Details(null);
        }
		else{
			product_Master.setAudio_Details(cleanUpString(product_Master_Dto.getAudio_Details()));
		}

		if (product_Master_Dto.getGraphics_Chipset_Brand().isEmpty() || product_Master_Dto.getGraphics_Chipset_Brand().equals(",")) {
            product_Master.setGraphics_Chipset_Brand(null);
        }
		else{
			product_Master.setGraphics_Chipset_Brand(cleanUpString(product_Master_Dto.getGraphics_Chipset_Brand()));
		}

		if (product_Master_Dto.getGraphics_Chipset_Brand().isEmpty() || product_Master_Dto.getGraphics_Chipset_Brand().equals(",")) {
            product_Master.setGraphics_Chipset_Brand(null);
        }
		else{
			product_Master.setGraphics_Chipset_Brand(cleanUpString(product_Master_Dto.getGraphics_Chipset_Brand()));
		}

		if (product_Master_Dto.getGraphics_RAM_Type().isEmpty() || product_Master_Dto.getGraphics_RAM_Type().equals(",")) {
            product_Master.setGraphics_RAM_Type(null);
        }
		else{
			product_Master.setGraphics_RAM_Type(cleanUpString(product_Master_Dto.getGraphics_RAM_Type()));
		}

		if (product_Master_Dto.getGraphics_Card_Ram_Size().isEmpty() || product_Master_Dto.getGraphics_Card_Ram_Size().equals(",")) {
            product_Master.setGraphics_Card_Ram_Size(null);
        }
		else{
			product_Master.setGraphics_Card_Ram_Size(cleanUpString(product_Master_Dto.getGraphics_Card_Ram_Size()));
		}

		if (product_Master_Dto.getGraphics_Card_Interface().isEmpty() || product_Master_Dto.getGraphics_Card_Interface().equals(",")) {
            product_Master.setGraphics_Card_Interface(null);
        }
		else{
			product_Master.setGraphics_Card_Interface(cleanUpString(product_Master_Dto.getGraphics_Card_Interface()));
		}

		if (product_Master_Dto.getConnectivity_Type().isEmpty() || product_Master_Dto.getConnectivity_Type().equals(",")) {
            product_Master.setConnectivity_Type(null);
        }
		else{
			product_Master.setConnectivity_Type(cleanUpString(product_Master_Dto.getConnectivity_Type()));
		}

		if (product_Master_Dto.getNumber_of_USB_2_0_Ports().isEmpty() || product_Master_Dto.getNumber_of_USB_2_0_Ports().equals(",")) {
            product_Master.setNumber_of_USB_2_0_Ports(null);
        }
		else{
			product_Master.setNumber_of_USB_2_0_Ports(cleanUpString(product_Master_Dto.getNumber_of_USB_2_0_Ports()));
		}

		if (product_Master_Dto.getNumber_of_USB_3_0_Ports().isEmpty() || product_Master_Dto.getNumber_of_USB_3_0_Ports().equals(",")) {
            product_Master.setNumber_of_USB_3_0_Ports(null);
        }
		else{
			product_Master.setNumber_of_USB_3_0_Ports(cleanUpString(product_Master_Dto.getNumber_of_USB_3_0_Ports()));
		}

		if (product_Master_Dto.getOptical_Drive_Type().isEmpty() || product_Master_Dto.getOptical_Drive_Type().equals(",")) {
            product_Master.setOptical_Drive_Type(null);
        }
		else{
			product_Master.setOptical_Drive_Type(cleanUpString(product_Master_Dto.getOptical_Drive_Type()));
		}

		if (product_Master_Dto.getRear_Webcam_Resolution().isEmpty() || product_Master_Dto.getRear_Webcam_Resolution().equals(",")) {
            product_Master.setRear_Webcam_Resolution(null);
        }
		else{
			product_Master.setRear_Webcam_Resolution(cleanUpString(product_Master_Dto.getRear_Webcam_Resolution()));
		}

		if (product_Master_Dto.getPower_Source().isEmpty() || product_Master_Dto.getPower_Source().equals(",")) {
            product_Master.setPower_Source(null);
        }
		else{
			product_Master.setPower_Source(cleanUpString(product_Master_Dto.getPower_Source()));
		}

		if (product_Master_Dto.getOperating_System().isEmpty() || product_Master_Dto.getOperating_System().equals(",")) {
            product_Master.setOperating_System(null);
        }
		else{
			product_Master.setOperating_System(cleanUpString(product_Master_Dto.getOperating_System()));
		}

		if (product_Master_Dto.getNumber_of_Lithium_Ion_Cells().isEmpty() || product_Master_Dto.getNumber_of_Lithium_Ion_Cells().equals(",")) {
            product_Master.setNumber_of_Lithium_Ion_Cells(null);
        }
		else{
			product_Master.setNumber_of_Lithium_Ion_Cells(cleanUpString(product_Master_Dto.getNumber_of_Lithium_Ion_Cells()));
		}
		
		if (product_Master_Dto.getMaterial().isEmpty() || product_Master_Dto.getMaterial().equals(",")) {
            product_Master.setMaterial(null);
        }
		else{
			product_Master.setMaterial(cleanUpString(product_Master_Dto.getMaterial()));
		}

		if (product_Master_Dto.getMovement_Detection_Technology().isEmpty() || product_Master_Dto.getMovement_Detection_Technology().equals(",")) {
            product_Master.setMovement_Detection_Technology(null);
        }
		else{
			product_Master.setMovement_Detection_Technology(cleanUpString(product_Master_Dto.getMovement_Detection_Technology()));
		}

		if (product_Master_Dto.getConnector_Type().isEmpty() || product_Master_Dto.getConnector_Type().equals(",")) {
            product_Master.setConnector_Type(null);
        }
		else{
			product_Master.setConnector_Type(cleanUpString(product_Master_Dto.getConnector_Type()));
		}

		if (product_Master_Dto.getBatteries_Included().isEmpty() || product_Master_Dto.getBatteries_Included().equals(",")) {
            product_Master.setBatteries_Included(null);
        }
		else{
			product_Master.setBatteries_Included(cleanUpString(product_Master_Dto.getBatteries_Included()));
		}
		
		if (product_Master_Dto.getBatteries_Required().isEmpty() || product_Master_Dto.getBatteries_Required().equals(",")) {
            product_Master.setBatteries_Required(null);
        }
		else{
			product_Master.setBatteries_Required(cleanUpString(product_Master_Dto.getBatteries_Required()));
		}

		if (product_Master_Dto.getHand_Orientation().isEmpty() || product_Master_Dto.getHand_Orientation().equals(",")) {
            product_Master.setHand_Orientation(null);
        }
		else{
			product_Master.setHand_Orientation(cleanUpString(product_Master_Dto.getHand_Orientation()));
		}

		if (product_Master_Dto.getMaximum_resolution().isEmpty() || product_Master_Dto.getMaximum_resolution().equals(",")) {
            product_Master.setMaximum_resolution(null);
        }
		else{
			product_Master.setMaximum_resolution(cleanUpString(product_Master_Dto.getMaximum_resolution()));
		}
		
		if (product_Master_Dto.getHardware_Platform().isEmpty() || product_Master_Dto.getHardware_Platform().equals(",")) {
            product_Master.setHardware_Platform(null);
        }
		else{
			product_Master.setHardware_Platform(cleanUpString(product_Master_Dto.getHardware_Platform()));
		}

		if (product_Master_Dto.getSpecial_feature().isEmpty() || product_Master_Dto.getSpecial_feature().equals(",")) {
            product_Master.setSpecial_feature(null);
        }
		else{
			product_Master.setSpecial_feature(cleanUpString(product_Master_Dto.getSpecial_feature()));
		}
		
		if (product_Master_Dto.getCompatible_device().isEmpty() || product_Master_Dto.getCompatible_device().equals(",")) {
            product_Master.setCompatible_device(null);
        }
		else{
			product_Master.setCompatible_device(cleanUpString(product_Master_Dto.getCompatible_device()));
		}
		product_Master_Repository.save(product_Master);
		// product_Master_Service.product_save(product_Master_Dto);
		return "addProduct";
	}
	
	@GetMapping("/addBrand")
	public String getAddBrandPage(@ModelAttribute("brand")Brand_Master_Dto brand_Master_Dto ,Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		return "addBrand";
	}
	
	@PostMapping("/addBrand")
	public String addBrandForm(@ModelAttribute("brand") Brand_Master_Dto brand_Master_Dto,Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		brand_Master_Service.brand_save(brand_Master_Dto);
//		model.addAttribute("brand_message", "Brand Added Successfuly !");
		return "addBrand";
	}
	
	@GetMapping("/addCategory")
	public String getAddCategoryPage(@ModelAttribute("category")Category_Master_Dto category_Master_Dto ,Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		return "addCategory";
	}
	
	@PostMapping("/addCategory")
	public String addCategoryForm(@ModelAttribute("category") Category_Master_Dto category_Master_Dto,Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		category_Master_Service.category_save(category_Master_Dto);
		
//		model.addAttribute("category_message", "Category Added Successfuly !");
		return "addCategory";
	}

	@GetMapping("/edit")
	public String showEditProductPage(Model model, @RequestParam long id,Principal principal){
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);

		Product_Master product_Master=product_Master_Repository.findById(id).get();
		model.addAttribute("products", product_Master);

		Product_Master_Dto product_Master_Dto=new Product_Master_Dto();
		product_Master_Dto.setProduct_name(product_Master.getProduct_name());
		product_Master_Dto.setProduct_Price(product_Master.getProduct_Price());
		product_Master_Dto.setManufacturer(product_Master.getManufacturer());
		product_Master_Dto.setSeries(product_Master.getSeries());
		product_Master_Dto.setColour(product_Master.getColour());
		product_Master_Dto.setForm_Factor(product_Master.getForm_Factor());
		product_Master_Dto.setProduct_Height(product_Master.getProduct_Height());
		product_Master_Dto.setProduct_Weight(product_Master.getProduct_Weight());
		product_Master_Dto.setStanding_screen_display_size(product_Master.getStanding_screen_display_size());
		product_Master_Dto.setScreen_Resolution(product_Master.getScreen_Resolution());
		product_Master_Dto.setProduct_Dimensions(product_Master.getProduct_Dimensions());
		product_Master_Dto.setBatteries(product_Master.getBatteries());
		product_Master_Dto.setProcessor_Brand(product_Master.getProcessor_Brand());
		product_Master_Dto.setProcessor_Type(product_Master.getProcessor_Type());
		product_Master_Dto.setProcessor_Speed(product_Master.getProcessor_Speed());
		product_Master_Dto.setRAM_Size(product_Master.getRAM_Size());
		product_Master_Dto.setMemory_Technology(product_Master.getMemory_Technology());
		product_Master_Dto.setMaximum_Memory_Supported(product_Master.getMaximum_Memory_Supported());
		product_Master_Dto.setHard_Disk_Type_Description(product_Master.getHard_Disk_Type_Description());
		product_Master_Dto.setAudio_Details(product_Master.getAudio_Details());
		product_Master_Dto.setGraphics_Chipset_Brand(product_Master.getGraphics_Chipset_Brand());
		product_Master_Dto.setGraphics_RAM_Type(product_Master.getGraphics_RAM_Type());
		product_Master_Dto.setGraphics_Card_Ram_Size(product_Master.getGraphics_Card_Ram_Size());
		product_Master_Dto.setGraphics_Card_Interface(product_Master.getGraphics_Card_Interface());
		product_Master_Dto.setConnectivity_Type(product_Master.getConnectivity_Type());
		product_Master_Dto.setNumber_of_USB_2_0_Ports(product_Master.getNumber_of_USB_2_0_Ports());
		product_Master_Dto.setNumber_of_USB_3_0_Ports(product_Master.getNumber_of_USB_3_0_Ports());
		product_Master_Dto.setOptical_Drive_Type(product_Master.getOptical_Drive_Type());
		product_Master_Dto.setRear_Webcam_Resolution(product_Master.getRear_Webcam_Resolution());
		product_Master_Dto.setPower_Source(product_Master.getPower_Source());
		product_Master_Dto.setOperating_System(product_Master.getOperating_System());
		product_Master_Dto.setNumber_of_Lithium_Ion_Cells(product_Master.getNumber_of_Lithium_Ion_Cells());
		product_Master_Dto.setIncluded_Components(product_Master.getIncluded_Components());
		product_Master_Dto.setCountry_of_Origin(product_Master.getCountry_of_Origin());
		product_Master_Dto.setProduct_Decscription(product_Master.getProduct_Decscription());
		product_Master_Dto.setProduct_Warranty(product_Master.getProduct_Warranty());
		product_Master_Dto.setMaterial(product_Master.getMaterial());
		product_Master_Dto.setMovement_Detection_Technology(product_Master.getMovement_Detection_Technology());
		product_Master_Dto.setConnector_Type(product_Master.getConnector_Type());
		product_Master_Dto.setBatteries_Included(product_Master.getBatteries_Included());
		product_Master_Dto.setBatteries_Required(product_Master.getBatteries_Required());
		product_Master_Dto.setHand_Orientation(product_Master.getHand_Orientation());
		product_Master_Dto.setMaximum_resolution(product_Master.getMaximum_resolution());
		product_Master_Dto.setHardware_Platform(product_Master.getHardware_Platform());
		product_Master_Dto.setSpecial_feature(product_Master.getSpecial_feature());
		product_Master_Dto.setCompatible_device(product_Master.getCompatible_device());
		product_Master_Dto.setStockquantity(product_Master.getStockquantity());

		model.addAttribute("product", product_Master_Dto);

		return "editProduct";
	}

	@PostMapping("/edit")
	public String editProductPage(Principal principal,Model model, @RequestParam long id,@Valid @ModelAttribute Product_Master_Dto product_Master_Dto,BindingResult result){
		
			UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user_Master", userDetails);
		try {
			Product_Master product_Master=product_Master_Repository.findById(id).get();
			model.addAttribute("products", product_Master);
			

			if (result.hasErrors()) {
				return "editProduct";
			}

			if (!product_Master_Dto.getProduct_Image().isEmpty()) {
				//delete old image
				String uploadDir="public/images/";
				Path oldImagePath=Paths.get(uploadDir+product_Master.getProduct_Image() );
				try {
					Files.delete(oldImagePath);
				} catch (Exception e) {
					System.out.println("Exception: "+e.getMessage());
				}
			
				//save new image file
				MultipartFile image=product_Master_Dto.getProduct_Image();
				Date createdAt=new Date();
				String storageFileName=createdAt.getTime()+"_"+image.getOriginalFilename();
				try(InputStream inputStream=image.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir+storageFileName),StandardCopyOption.REPLACE_EXISTING);
				}
				product_Master.setProduct_Image(storageFileName);
			}
			
			product_Master.setProduct_name(product_Master_Dto.getProduct_name());
			product_Master.setProduct_Price(product_Master_Dto.getProduct_Price());
			product_Master.setManufacturer(product_Master_Dto.getManufacturer());
			product_Master.setSeries(product_Master_Dto.getSeries());
			product_Master.setColour(product_Master_Dto.getColour());
			product_Master.setForm_Factor(product_Master_Dto.getForm_Factor());
			product_Master.setProduct_Height(product_Master_Dto.getProduct_Height());
			product_Master.setProduct_Weight(product_Master_Dto.getProduct_Weight());
			product_Master.setStanding_screen_display_size(product_Master_Dto.getStanding_screen_display_size());
			product_Master.setScreen_Resolution(product_Master_Dto.getScreen_Resolution());
			product_Master.setProduct_Dimensions(product_Master_Dto.getProduct_Dimensions());
			product_Master.setBatteries(product_Master_Dto.getBatteries());
			product_Master.setProcessor_Brand(product_Master_Dto.getProcessor_Brand());
			product_Master.setProcessor_Type(product_Master_Dto.getProcessor_Type());
			product_Master.setProcessor_Speed(product_Master_Dto.getProcessor_Speed());
			product_Master.setRAM_Size(product_Master_Dto.getRAM_Size());
			product_Master.setMemory_Technology(product_Master_Dto.getMemory_Technology());
			product_Master.setMaximum_Memory_Supported(product_Master_Dto.getMaximum_Memory_Supported());
			product_Master.setHard_Disk_Type_Description(product_Master_Dto.getHard_Disk_Type_Description());
			product_Master.setAudio_Details(product_Master_Dto.getAudio_Details());
			product_Master.setGraphics_Chipset_Brand(product_Master_Dto.getGraphics_Chipset_Brand());
			product_Master.setGraphics_RAM_Type(product_Master_Dto.getGraphics_RAM_Type());
			product_Master.setGraphics_Card_Ram_Size(product_Master_Dto.getGraphics_Card_Ram_Size());
			product_Master.setGraphics_Card_Interface(product_Master_Dto.getGraphics_Card_Interface());
			product_Master.setConnectivity_Type(product_Master_Dto.getConnectivity_Type());
			product_Master.setNumber_of_USB_2_0_Ports(product_Master_Dto.getNumber_of_USB_2_0_Ports());
			product_Master.setNumber_of_USB_3_0_Ports(product_Master_Dto.getNumber_of_USB_3_0_Ports());
			product_Master.setOptical_Drive_Type(product_Master_Dto.getOptical_Drive_Type());
			product_Master.setRear_Webcam_Resolution(product_Master_Dto.getRear_Webcam_Resolution());
			product_Master.setPower_Source(product_Master_Dto.getPower_Source());
			product_Master.setOperating_System(product_Master_Dto.getOperating_System());
			product_Master.setNumber_of_Lithium_Ion_Cells(product_Master_Dto.getNumber_of_Lithium_Ion_Cells());
			product_Master.setIncluded_Components(product_Master_Dto.getIncluded_Components());
			product_Master.setCountry_of_Origin(product_Master_Dto.getCountry_of_Origin());
			product_Master.setProduct_Decscription(product_Master_Dto.getProduct_Decscription());
			product_Master.setProduct_Warranty(product_Master_Dto.getProduct_Warranty());
			product_Master.setMaterial(product_Master_Dto.getMaterial());
			product_Master.setMovement_Detection_Technology(product_Master_Dto.getMovement_Detection_Technology());
			product_Master.setConnector_Type(product_Master_Dto.getConnector_Type());
			product_Master.setBatteries_Included(product_Master_Dto.getBatteries_Included());
			product_Master.setBatteries_Required(product_Master_Dto.getBatteries_Required());
			product_Master.setHand_Orientation(product_Master_Dto.getHand_Orientation());
			product_Master.setMaximum_resolution(product_Master_Dto.getMaximum_resolution());
			product_Master.setHardware_Platform(product_Master_Dto.getHardware_Platform());
			product_Master.setSpecial_feature(product_Master_Dto.getSpecial_feature());
			product_Master.setCompatible_device(product_Master_Dto.getCompatible_device());
			product_Master.setStockquantity(product_Master_Dto.getStockquantity());

			product_Master_Repository.save(product_Master);
			// model.addAttribute("product", product_Master);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return "redirect:/viewproduct";
	}

	@GetMapping("/delete")
    public String deleteProduct(@RequestParam long id){
		try {
			Product_Master product_Master=product_Master_Repository.findById(id).get();
			//delete product image from images folder
			Path imagePath=Paths.get("public/images/"+product_Master.getProduct_Image());

			try {
                Files.delete(imagePath);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
            }
			//delete product from database
			product_Master_Repository.delete(product_Master);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return "redirect:/viewproduct";
	}

	@GetMapping("/moreDetails")
	public String getMoreDetailPage(@RequestParam long id,Model model,Principal principal){
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		Product_Master product_Master=product_Master_Repository.findById(id).get();
		model.addAttribute("products", product_Master);
		return "moreDetail";
	}

	@GetMapping("/buttonp")
	public String getbuttonp(){
		return "buttonp";
	}

	@GetMapping("/addPaymentMethod")
	public String getaddPaymentMethod(@ModelAttribute("addPaymentMethodDto") Payment_Method_Dto payment_Method_Dto, Model model, Principal principal){
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		return "addPaymentMethod";
	}

	@PostMapping("/addPaymentMethod")
	public String addPaymentMethod(Model model, Principal principal,@ModelAttribute("addPaymentMethodDto") Payment_Method_Dto payment_Method_Dto){
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		payment_Method_Service.savePayment_Method(payment_Method_Dto);
		return "addPaymentMethod";
	}

	// @GetMapping("/detailLaptops")
	// public String getLaptopDetialPage(Model model){
	// 	List<Product_Master> product_Master = product_Master_Repository.findByForm_Factor("Laptop");
	// 	model.addAttribute("getLaptopList", product_Master);
	// 	return "detailLaptops";
	// }


}
