package com.springboot.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.techhub.model.Product_Master;
import com.springboot.techhub.repository.Product_Master_Repository;

@Service
public class Product_Master_ServiceImpl implements Product_Master_Service {

	@Autowired
	private Product_Master_Repository product_Master_Repository;

	@Override
	public List<Product_Master> getAllProduct_Masters() {
		
		return product_Master_Repository.findAll();
	}

	@Override
	public List<Product_Master> getRecentProducts() {
		return product_Master_Repository.findTop8ByOrderByCreatedAtDesc();
	}

	@Override
	public List<Product_Master> getFeaturedProducts() {
		return product_Master_Repository.findFirst8ByOrderByCreatedAt();
	}

	@Override
	public Page<Product_Master> pageProducts(int pageNo) {
		
		Pageable pageable=PageRequest.of(pageNo, 10);
		Page<Product_Master> product_masterPage= product_Master_Repository.pageProduct_Master(pageable);
		return product_masterPage;
	}

	@Override
	public Page<Product_Master> getAllProduct(Integer pageNo, Integer pageSize) {
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		return product_Master_Repository.findAll(pageable);
	}

	@Override
	public List<Product_Master> getAllProducts() {
		return product_Master_Repository.findAll();
	}

	

	// @Override
	// public Product_Master product_save(Product_Master_Dto product_Master_Dto) {

	// 	Product_Master product_Master = new Product_Master();
	// 	product_Master.setProduct_name(product_Master_Dto.getProduct_name());
	// 	product_Master.setProduct_Price(product_Master_Dto.getProduct_Price());
	// 	product_Master.setManufacturer(product_Master_Dto.getManufacturer());
	// 	product_Master.setSeries(product_Master_Dto.getSeries());
	// 	product_Master.setColour(product_Master_Dto.getColour());
	// 	product_Master.setForm_Factor(product_Master_Dto.getForm_Factor());
	// 	product_Master.setProduct_Height(product_Master_Dto.getProduct_Height());
	// 	product_Master.setProduct_Weight(product_Master_Dto.getProduct_Weight());

	// 	if (product_Master_Dto.getStanding_screen_display_size().isEmpty()) {
    //         product_Master.setStanding_screen_display_size(null);
    //     }
	// 	else{
	// 		product_Master.setStanding_screen_display_size(product_Master_Dto.getStanding_screen_display_size());
	// 	}
		
	// 	product_Master.setScreen_Resolution(product_Master_Dto.getScreen_Resolution());
	// 	product_Master.setProduct_Dimensions(product_Master_Dto.getProduct_Dimensions());

	// 	if (product_Master_Dto.getBatteries().isEmpty()) {
    //         product_Master.setBatteries(null);
    //     }
	// 	else{
	// 		product_Master.setBatteries(product_Master_Dto.getBatteries());
	// 	}
		
	// 	if (product_Master_Dto.getProcessor_Brand().isEmpty()) {
    //         product_Master.setProcessor_Brand(null);
    //     }
	// 	else{
	// 		product_Master.setProcessor_Brand(product_Master_Dto.getProcessor_Brand());
	// 	}
		
	// 	if (product_Master_Dto.getProcessor_Type().isEmpty()) {
    //         product_Master.setProcessor_Type(null);
    //     }
	// 	else{
	// 		product_Master.setProcessor_Type(product_Master_Dto.getProcessor_Type());
	// 	}

	// 	if (product_Master_Dto.getProcessor_Speed().isEmpty()) {
    //         product_Master.setProcessor_Speed(null);
    //     }
	// 	else{
	// 		product_Master.setProcessor_Speed(product_Master_Dto.getProcessor_Speed());
	// 	}
		
	// 	if (product_Master_Dto.getRAM_Size().isEmpty()) {
    //         product_Master.setRAM_Size(null);
    //     }
	// 	else{
	// 		product_Master.setRAM_Size(product_Master_Dto.getRAM_Size());
	// 	}
		
		
	// 	product_Master.setMemory_Technology(product_Master_Dto.getMemory_Technology());
	// 	product_Master.setMaximum_Memory_Supported(product_Master_Dto.getMaximum_Memory_Supported());
	// 	product_Master.setHard_Disk_Type_Description(product_Master_Dto.getHard_Disk_Type_Description());
	// 	product_Master.setAudio_Details(product_Master_Dto.getAudio_Details());
	// 	product_Master.setGraphics_Chipset_Brand(product_Master_Dto.getGraphics_Chipset_Brand());
	// 	product_Master.setGraphics_RAM_Type(product_Master_Dto.getGraphics_RAM_Type());
	// 	product_Master.setGraphics_Card_Ram_Size(product_Master_Dto.getGraphics_Card_Ram_Size());
	// 	product_Master.setGraphics_Card_Interface(product_Master_Dto.getGraphics_Card_Interface());
	// 	product_Master.setConnectivity_Type(product_Master_Dto.getConnectivity_Type());
	// 	product_Master.setNumber_of_USB_2_0_Ports(product_Master_Dto.getNumber_of_USB_2_0_Ports());
	// 	product_Master.setNumber_of_USB_3_0_Ports(product_Master_Dto.getNumber_of_USB_3_0_Ports());
	// 	product_Master.setOptical_Drive_Type(product_Master_Dto.getOptical_Drive_Type());
	// 	product_Master.setRear_Webcam_Resolution(product_Master_Dto.getRear_Webcam_Resolution());
	// 	product_Master.setPower_Source(product_Master_Dto.getPower_Source());
	// 	product_Master.setOperating_System(product_Master_Dto.getOperating_System());
	// 	product_Master.setNumber_of_Lithium_Ion_Cells(product_Master_Dto.getNumber_of_Lithium_Ion_Cells());
	// 	product_Master.setIncluded_Components(product_Master_Dto.getIncluded_Components());
	// 	product_Master.setCountry_of_Origin(product_Master_Dto.getCountry_of_Origin());
	// 	product_Master.setProduct_Decscription(product_Master_Dto.getProduct_Decscription());
	// 	product_Master.setProduct_Warranty(product_Master_Dto.getProduct_Warranty());
	// 	product_Master.setMaterial(product_Master_Dto.getMaterial());
	// 	product_Master.setMovement_Detection_Technology(product_Master_Dto.getMovement_Detection_Technology());
	// 	product_Master.setConnector_Type(product_Master_Dto.getConnector_Type());
	// 	product_Master.setBatteries_Included(product_Master_Dto.getBatteries_Included());
	// 	product_Master.setBatteries_Required(product_Master_Dto.getBatteries_Required());
	// 	product_Master.setHand_Orientation(product_Master_Dto.getHand_Orientation());
	// 	product_Master.setMaximum_resolution(product_Master_Dto.getMaximum_resolution());
	// 	product_Master.setHardware_Platform(product_Master_Dto.getHardware_Platform());
	// 	product_Master.setSpecial_feature(product_Master_Dto.getSpecial_feature());
	// 	product_Master.setCompatible_device(product_Master_Dto.getCompatible_device());

	// 	return product_Master_Repository.save(product_Master);
	// }

	
}
