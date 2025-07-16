package com.springboot.techhub.model;

import java.util.Date;

// import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;

	private String product_name;

	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
	// private Category_Master category_Master;

	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "brand_id", referencedColumnName = "brand_id", nullable = false)
	// private Brand_Master brand_Master;

	@Column(nullable = false)
	private String Product_Image;

	@Column(nullable = false)
	private double product_Price;

	@Column(nullable = false)
	private String Manufacturer;

	private String Series;

	@Column(nullable = false)
	private String colour;

	@Column(nullable = false)
	private String Form_Factor;

	public Date createdAt;

	private String product_Height;

	private String product_Weight;

	private long stockquantity;

	@Column(nullable = true)
	private String Standing_screen_display_size;

	@Column(nullable = true)
	private String Screen_Resolution;

	@Column(nullable = true)
	private String Product_Dimensions;

	@Column(nullable = true)
	private String Batteries;

	@Column(nullable = true)
	private String Processor_Brand;

	@Column(nullable = true)
	private String Processor_Type;

	@Column(nullable = true)
	private String Processor_Speed;

	@Column(nullable = true)
	private String Processor_Count;

	@Column(nullable = true)
	private String RAM_Size;

	@Column(nullable = true)
	private String Memory_Technology;

	@Column(nullable = true)
	private String Maximum_Memory_Supported;

	@Column(nullable = true)
	private String Memory_Clock_Speed;

	@Column(nullable = true)
	private String Hard_Drive_Size;

	@Column(nullable = true)
	private String Hard_Disk_Type_Description;

	@Column(nullable = true)
	private String Audio_Details;

	@Column(nullable = true)
	private String Graphics_Chipset_Brand;

	@Column(nullable = true)
	private String Graphics_Card_Description;

	@Column(nullable = true)
	private String Graphics_RAM_Type;

	@Column(nullable = true)
	private String Graphics_Card_Ram_Size;

	@Column(nullable = true)
	private String Graphics_Card_Interface;

	@Column(nullable = true)
	private String Connectivity_Type;

	@Column(nullable = true)
	private String Number_of_USB_2_0_Ports;

	@Column(nullable = true)
	private String Number_of_USB_3_0_Ports;

	@Column(nullable = true)
	private String Optical_Drive_Type;

	@Column(nullable = true)
	private String Rear_Webcam_Resolution;

	@Column(nullable = true)
	private String Power_Source;

	@Column(nullable = true)
	private String Operating_System;

	@Column(nullable = true)
	private String Number_of_Lithium_Ion_Cells;

	@Column(nullable = true)
	private String Included_Components;

	@Column(nullable = true)
	private String Country_of_Origin;

	@Column(nullable = true)
	private String Product_Decscription;

	@Column(nullable = true)
	private String Product_Warranty;

	@Column(nullable = true)
	private String Material;

	@Column(nullable = true)
	private String Movement_Detection_Technology;
	
	@Column(nullable = true)
	private String Connector_Type;
	
	@Column(nullable = true)
	private String Batteries_Included;
	
	@Column(nullable = true)
	private String Batteries_Required;
	
	@Column(nullable = true)
	private String Hand_Orientation;
	
	@Column(nullable = true)
	private String Maximum_resolution;
	
	@Column(nullable = true)
	private String Hardware_Platform;
	
	@Column(nullable = true)
	private String Special_feature;
	
	@Column(nullable = true)
	private String Compatible_device;
	
	@Column(nullable = true)
	private String RAM_Type;


	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	// public Category_Master getCategory_Master() {
	// 	return category_Master;
	// }

	// public void setCategory_Master(Category_Master category_Master) {
	// 	this.category_Master = category_Master;
	// }

	// public Brand_Master getBrand_Master() {
	// 	return brand_Master;
	// }

	// public void setBrand_Master(Brand_Master brand_Master) {
	// 	this.brand_Master = brand_Master;
	// }

	public String getProduct_Image() {
		return Product_Image;
	}

	public void setProduct_Image(String product_Image) {
		Product_Image = product_Image;
	}

	public double getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public String getSeries() {
		return Series;
	}

	public void setSeries(String series) {
		Series = series;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getForm_Factor() {
		return Form_Factor;
	}

	public void setForm_Factor(String form_Factor) {
		Form_Factor = form_Factor;
	}
	public Date getcreatedAt() {
		return createdAt;
	}
	public void setcreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getProduct_Height() {
		return product_Height;
	}

	public void setProduct_Height(String product_Height) {
		this.product_Height = product_Height;
	}

	public String getProduct_Weight() {
		return product_Weight;
	}

	public void setProduct_Weight(String product_Weight) {
		this.product_Weight = product_Weight;
	}

	public String getStanding_screen_display_size() {
		return Standing_screen_display_size;
	}

	public void setStanding_screen_display_size(String standing_screen_display_size) {
		Standing_screen_display_size = standing_screen_display_size;
	}

	public String getScreen_Resolution() {
		return Screen_Resolution;
	}

	public void setScreen_Resolution(String screen_Resolution) {
		Screen_Resolution = screen_Resolution;
	}

	public String getProduct_Dimensions() {
		return Product_Dimensions;
	}

	public void setProduct_Dimensions(String product_Dimensions) {
		Product_Dimensions = product_Dimensions;
	}

	public String getBatteries() {
		return Batteries;
	}

	public void setBatteries(String batteries) {
		Batteries = batteries;
	}

	public String getProcessor_Brand() {
		return Processor_Brand;
	}

	public void setProcessor_Brand(String processor_Brand) {
		Processor_Brand = processor_Brand;
	}

	public String getProcessor_Type() {
		return Processor_Type;
	}

	public void setProcessor_Type(String processor_Type) {
		Processor_Type = processor_Type;
	}

	public String getProcessor_Speed() {
		return Processor_Speed;
	}

	public void setProcessor_Speed(String processor_Speed) {
		Processor_Speed = processor_Speed;
	}

	public String getProcessor_Count() {
		return Processor_Count;
	}

	public void setProcessor_Count(String processor_Count) {
		Processor_Count = processor_Count;
	}

	public String getRAM_Size() {
		return RAM_Size;
	}

	public void setRAM_Size(String rAM_Size) {
		RAM_Size = rAM_Size;
	}

	public String getMemory_Technology() {
		return Memory_Technology;
	}

	public void setMemory_Technology(String memory_Technology) {
		Memory_Technology = memory_Technology;
	}

	public String getMaximum_Memory_Supported() {
		return Maximum_Memory_Supported;
	}

	public void setMaximum_Memory_Supported(String maximum_Memory_Supported) {
		Maximum_Memory_Supported = maximum_Memory_Supported;
	}

	public String getMemory_Clock_Speed() {
		return Memory_Clock_Speed;
	}

	public void setMemory_Clock_Speed(String memory_Clock_Speed) {
		Memory_Clock_Speed = memory_Clock_Speed;
	}

	public String getHard_Drive_Size() {
		return Hard_Drive_Size;
	}

	public void setHard_Drive_Size(String hard_Drive_Size) {
		Hard_Drive_Size = hard_Drive_Size;
	}

	public String getHard_Disk_Type_Description() {
		return Hard_Disk_Type_Description;
	}

	public void setHard_Disk_Type_Description(String hard_Disk_Type_Description) {
		Hard_Disk_Type_Description = hard_Disk_Type_Description;
	}

	public String getAudio_Details() {
		return Audio_Details;
	}

	public void setAudio_Details(String audio_Details) {
		Audio_Details = audio_Details;
	}

	public String getGraphics_Chipset_Brand() {
		return Graphics_Chipset_Brand;
	}

	public void setGraphics_Chipset_Brand(String graphics_Chipset_Brand) {
		Graphics_Chipset_Brand = graphics_Chipset_Brand;
	}

	public String getGraphics_Card_Description() {
		return Graphics_Card_Description;
	}

	public void setGraphics_Card_Description(String graphics_Card_Description) {
		Graphics_Card_Description = graphics_Card_Description;
	}

	public String getGraphics_RAM_Type() {
		return Graphics_RAM_Type;
	}

	public void setGraphics_RAM_Type(String graphics_RAM_Type) {
		Graphics_RAM_Type = graphics_RAM_Type;
	}

	public String getGraphics_Card_Ram_Size() {
		return Graphics_Card_Ram_Size;
	}

	public void setGraphics_Card_Ram_Size(String graphics_Card_Ram_Size) {
		Graphics_Card_Ram_Size = graphics_Card_Ram_Size;
	}

	public String getGraphics_Card_Interface() {
		return Graphics_Card_Interface;
	}

	public void setGraphics_Card_Interface(String graphics_Card_Interface) {
		Graphics_Card_Interface = graphics_Card_Interface;
	}

	public String getConnectivity_Type() {
		return Connectivity_Type;
	}

	public void setConnectivity_Type(String connectivity_Type) {
		Connectivity_Type = connectivity_Type;
	}

	public String getNumber_of_USB_2_0_Ports() {
		return Number_of_USB_2_0_Ports;
	}

	public void setNumber_of_USB_2_0_Ports(String number_of_USB_2_0_Ports) {
		Number_of_USB_2_0_Ports = number_of_USB_2_0_Ports;
	}

	public String getNumber_of_USB_3_0_Ports() {
		return Number_of_USB_3_0_Ports;
	}

	public void setNumber_of_USB_3_0_Ports(String number_of_USB_3_0_Ports) {
		Number_of_USB_3_0_Ports = number_of_USB_3_0_Ports;
	}

	public String getOptical_Drive_Type() {
		return Optical_Drive_Type;
	}

	public void setOptical_Drive_Type(String optical_Drive_Type) {
		Optical_Drive_Type = optical_Drive_Type;
	}

	public String getRear_Webcam_Resolution() {
		return Rear_Webcam_Resolution;
	}

	public void setRear_Webcam_Resolution(String rear_Webcam_Resolution) {
		Rear_Webcam_Resolution = rear_Webcam_Resolution;
	}

	public String getPower_Source() {
		return Power_Source;
	}

	public void setPower_Source(String power_Source) {
		Power_Source = power_Source;
	}

	public String getOperating_System() {
		return Operating_System;
	}

	public void setOperating_System(String operating_System) {
		Operating_System = operating_System;
	}

	public String getNumber_of_Lithium_Ion_Cells() {
		return Number_of_Lithium_Ion_Cells;
	}

	public void setNumber_of_Lithium_Ion_Cells(String number_of_Lithium_Ion_Cells) {
		Number_of_Lithium_Ion_Cells = number_of_Lithium_Ion_Cells;
	}

	public String getIncluded_Components() {
		return Included_Components;
	}

	public void setIncluded_Components(String included_Components) {
		Included_Components = included_Components;
	}

	public String getCountry_of_Origin() {
		return Country_of_Origin;
	}

	public void setCountry_of_Origin(String country_of_Origin) {
		Country_of_Origin = country_of_Origin;
	}

	public String getProduct_Decscription() {
		return Product_Decscription;
	}

	public void setProduct_Decscription(String product_Decscription) {
		Product_Decscription = product_Decscription;
	}

	public String getProduct_Warranty() {
		return Product_Warranty;
	}

	public void setProduct_Warranty(String product_Warranty) {
		Product_Warranty = product_Warranty;
	}
	

	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}

	public String getMovement_Detection_Technology() {
		return Movement_Detection_Technology;
	}
	public void setMovement_Detection_Technology(String movement_Detection_Technology) {
		Movement_Detection_Technology = movement_Detection_Technology;
	}

	public String getConnector_Type() {
		return Connector_Type;
	}
	public void setConnector_Type(String connector_Type) {
		Connector_Type = connector_Type;
	}

	public String getBatteries_Included() {
		return Batteries_Included;
	}
	public void setBatteries_Included(String batteries_Included) {
		Batteries_Included = batteries_Included;
	}

	public String getBatteries_Required() {
		return Batteries_Required;
	}
	public void setBatteries_Required(String batteries_Required) {
		Batteries_Required = batteries_Required;
	}

	public String getHand_Orientation() {
		return Hand_Orientation;
	}
	public void setHand_Orientation(String hand_Orientation) {
		Hand_Orientation = hand_Orientation;
	}

	public String getMaximum_resolution() {
		return Maximum_resolution;
	}
	public void setMaximum_resolution(String maximum_resolution) {
		Maximum_resolution = maximum_resolution;
	}

	public String getHardware_Platform() {
		return Hardware_Platform;
	}
	public void setHardware_Platform(String hardware_Platform) {
		Hardware_Platform = hardware_Platform;
	}

	public String getSpecial_feature() {
		return Special_feature;
	}
	public void setSpecial_feature(String special_feature) {
		Special_feature = special_feature;
	}

	public String getCompatible_device() {
		return Compatible_device;
	}
	public void setCompatible_device(String compatible_device) {
		Compatible_device = compatible_device;
	}

	public String getRAM_Type() {
		return RAM_Type;
	}
	public void setRAM_Type(String rAM_Type) {
		RAM_Type = rAM_Type;
	}
	
	public long getStockquantity() {
		return stockquantity;
	}

	public void setStockquantity(long stockquantity) {
		this.stockquantity = stockquantity;
	}

	// public Product_Master() {
	// 	super();
	// }

	// public Product_Master(String product_name, String product_Image, BigDecimal product_Price, String manufacturer,
	// 		String series, String colour, String form_Factor,Date createdAt, String product_Height, String product_Weight,
	// 		String standing_screen_display_size, String screen_Resolution, String product_Dimensions, String batteries,
	// 		String processor_Brand, String processor_Type, String processor_Speed, String processor_Count,
	// 		String rAM_Size, String memory_Technology, String maximum_Memory_Supported, String memory_Clock_Speed,
	// 		String hard_Drive_Size, String hard_Disk_Type_Description, String audio_Details,
	// 		String graphics_Chipset_Brand, String graphics_Card_Description, String graphics_RAM_Type,
	// 		String graphics_Card_Ram_Size, String graphics_Card_Interface, String connectivity_Type,
	// 		String number_of_USB_2_0_Ports, String number_of_USB_3_0_Ports, String optical_Drive_Type,
	// 		String rear_Webcam_Resolution, String power_Source, String operating_System,
	// 		String number_of_Lithium_Ion_Cells, String included_Components, String country_of_Origin,
	// 		String product_Decscription, String product_Warranty, String material, String movement_Detection_Technology,
	// 		String connector_Type, String batteries_Included, String batteries_Required, String hand_Orientation,
	// 		String maximum_resolution, String hardware_Platform, String special_feature, String compatible_device,
	// 		String rAM_Type) {
	// 	this.product_name = product_name;
	// 	Product_Image = product_Image;
	// 	this.product_Price = product_Price;
	// 	Manufacturer = manufacturer;
	// 	Series = series;
	// 	this.colour = colour;
	// 	Form_Factor = form_Factor;
	// 	this.createdAt=createdAt;
	// 	this.product_Height = product_Height;
	// 	this.product_Weight = product_Weight;
	// 	Standing_screen_display_size = standing_screen_display_size;
	// 	Screen_Resolution = screen_Resolution;
	// 	Product_Dimensions = product_Dimensions;
	// 	Batteries = batteries;
	// 	Processor_Brand = processor_Brand;
	// 	Processor_Type = processor_Type;
	// 	Processor_Speed = processor_Speed;
	// 	Processor_Count = processor_Count;
	// 	RAM_Size = rAM_Size;
	// 	Memory_Technology = memory_Technology;
	// 	Maximum_Memory_Supported = maximum_Memory_Supported;
	// 	Memory_Clock_Speed = memory_Clock_Speed;
	// 	Hard_Drive_Size = hard_Drive_Size;
	// 	Hard_Disk_Type_Description = hard_Disk_Type_Description;
	// 	Audio_Details = audio_Details;
	// 	Graphics_Chipset_Brand = graphics_Chipset_Brand;
	// 	Graphics_Card_Description = graphics_Card_Description;
	// 	Graphics_RAM_Type = graphics_RAM_Type;
	// 	Graphics_Card_Ram_Size = graphics_Card_Ram_Size;
	// 	Graphics_Card_Interface = graphics_Card_Interface;
	// 	Connectivity_Type = connectivity_Type;
	// 	Number_of_USB_2_0_Ports = number_of_USB_2_0_Ports;
	// 	Number_of_USB_3_0_Ports = number_of_USB_3_0_Ports;
	// 	Optical_Drive_Type = optical_Drive_Type;
	// 	Rear_Webcam_Resolution = rear_Webcam_Resolution;
	// 	Power_Source = power_Source;
	// 	Operating_System = operating_System;
	// 	Number_of_Lithium_Ion_Cells = number_of_Lithium_Ion_Cells;
	// 	Included_Components = included_Components;
	// 	Country_of_Origin = country_of_Origin;
	// 	Product_Decscription = product_Decscription;
	// 	Product_Warranty = product_Warranty;
	// 	Material = material;
	// 	Movement_Detection_Technology = movement_Detection_Technology;
	// 	Connector_Type = connector_Type;
	// 	Batteries_Included = batteries_Included;
	// 	Batteries_Required = batteries_Required;
	// 	Hand_Orientation = hand_Orientation;
	// 	Maximum_resolution = maximum_resolution;
	// 	Hardware_Platform = hardware_Platform;
	// 	Special_feature = special_feature;
	// 	Compatible_device = compatible_device;
	// 	RAM_Type = rAM_Type;
	// }

	

	// public Product_Master(String product_name, byte[] product_Image, BigDecimal product_Price, String manufacturer,
	// 		String series, String colour, String form_Factor, String product_Height, String product_Weight,
	// 		String standing_screen_display_size, String screen_Resolution, String product_Dimensions, String batteries,
	// 		String processor_Brand, String processor_Type, String processor_Speed, String processor_Count,
	// 		String rAM_Size, String memory_Technology, String maximum_Memory_Supported, String memory_Clock_Speed,
	// 		String hard_Drive_Size, String hard_Disk_Type_Description, String audio_Details,
	// 		String graphics_Chipset_Brand, String graphics_Card_Description, String graphics_RAM_Type,
	// 		String graphics_Card_Ram_Size, String graphics_Card_Interface, String connectivity_Type,
	// 		String number_of_USB_2_0_Ports, String number_of_USB_3_0_Ports, String optical_Drive_Type,
	// 		String rear_Webcam_Resolution, String power_Source, String operating_System,
	// 		String number_of_Lithium_Ion_Cells, String included_Components, String country_of_Origin,
	// 		String product_Decscription, String product_Warranty) {
		
	// 	this.product_name = product_name;
	// 	Product_Image = product_Image;
	// 	this.product_Price = product_Price;
	// 	Manufacturer = manufacturer;
	// 	Series = series;
	// 	this.colour = colour;
	// 	Form_Factor = form_Factor;
	// 	this.product_Height = product_Height;
	// 	this.product_Weight = product_Weight;
	// 	Standing_screen_display_size = standing_screen_display_size;
	// 	Screen_Resolution = screen_Resolution;
	// 	Product_Dimensions = product_Dimensions;
	// 	Batteries = batteries;
	// 	Processor_Brand = processor_Brand;
	// 	Processor_Type = processor_Type;
	// 	Processor_Speed = processor_Speed;
	// 	Processor_Count = processor_Count;
	// 	RAM_Size = rAM_Size;
	// 	Memory_Technology = memory_Technology;
	// 	Maximum_Memory_Supported = maximum_Memory_Supported;
	// 	Memory_Clock_Speed = memory_Clock_Speed;
	// 	Hard_Drive_Size = hard_Drive_Size;
	// 	Hard_Disk_Type_Description = hard_Disk_Type_Description;
	// 	Audio_Details = audio_Details;
	// 	Graphics_Chipset_Brand = graphics_Chipset_Brand;
	// 	Graphics_Card_Description = graphics_Card_Description;
	// 	Graphics_RAM_Type = graphics_RAM_Type;
	// 	Graphics_Card_Ram_Size = graphics_Card_Ram_Size;
	// 	Graphics_Card_Interface = graphics_Card_Interface;
	// 	Connectivity_Type = connectivity_Type;
	// 	Number_of_USB_2_0_Ports = number_of_USB_2_0_Ports;
	// 	Number_of_USB_3_0_Ports = number_of_USB_3_0_Ports;
	// 	Optical_Drive_Type = optical_Drive_Type;
	// 	Rear_Webcam_Resolution = rear_Webcam_Resolution;
	// 	Power_Source = power_Source;
	// 	Operating_System = operating_System;
	// 	Number_of_Lithium_Ion_Cells = number_of_Lithium_Ion_Cells;
	// 	Included_Components = included_Components;
	// 	Country_of_Origin = country_of_Origin;
	// 	Product_Decscription = product_Decscription;
	// 	Product_Warranty = product_Warranty;
	// }

}
