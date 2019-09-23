package com.metacube.assignment.EADSession9.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.assignment.EADSession9.dto.EmployeeDetails;
import com.metacube.assignment.EADSession9.dto.Friend;
import com.metacube.assignment.EADSession9.dto.FriendForEmp;
import com.metacube.assignment.EADSession9.dto.FriendProfile;
import com.metacube.assignment.EADSession9.model.pojo.Login;
import com.metacube.assignment.EADSession9.model.pojo.Pass;
import com.metacube.assignment.EADSession9.model.pojo.User;
import com.metacube.assignment.EADSession9.model.pojo.Vehicle;
import com.metacube.assignment.EADSession9.service.PassService;
import com.metacube.assignment.EADSession9.service.UserService;
import com.metacube.assignment.EADSession9.service.VehicleService;
import com.metacube.assignment.EADSession9.util.DTOUtil;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private PassService passService;

	@Value("${welcome.message}")
	private String welcomeMessage;

	@GetMapping("/registration")
	public String registerUser(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("user", new User());
		return "user";
	}
	@PostMapping("/registration")
	public String userAdded(@Validated User user, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "user";
		} else {
			if (user.getConfirmPassword().equals(user.getPassword())) {
				User dbUser = DTOUtil.map(user, User.class);
				if (!userService.userExists(user.getEmail())) {
					redirectAttributes.addFlashAttribute("msg","User added successfully");
					userService.addUser(dbUser);
					redirectAttributes.addAttribute("regId",userService.getUserRegId(user.getEmail()));
					model.addAttribute("vehicle", new Vehicle());
					return "redirect:/addVehicle";
				} else {
					redirectAttributes.addFlashAttribute("msg","User already exist");
					return "user";
				}

			} 
			else {
				ObjectError objectError = new ObjectError("pass","Passwords do not match");
				result.addError(objectError);
				return "user";
			}
		}
	}

	@GetMapping("/login")
	public String loginUser(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@PostMapping("/login")
	public String userLoggedIn(@Validated Login login, BindingResult result,HttpServletRequest request,final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			System.out.println("not logged in");
			return "login";
		} else {
			if (!userService.userExists(login.getEmail())) {
				redirectAttributes.addFlashAttribute("msg","User does not exist");
				return "redirect:/login";
			}
			String pass = userService.getPassword(login.getEmail());
			
			if (!pass.equals(login.getPassword())) {
				redirectAttributes.addFlashAttribute("msg","Password Incorrect");
				return "redirect:/login";
			}
			if(!userService.userAddedVehicle(userService.getUserRegId(login.getEmail()))){
				redirectAttributes.addAttribute("regId",userService.getUserRegId(login.getEmail()));
				model.addAttribute("vehicle", new Vehicle());
				return "addVehicle";
			}
			redirectAttributes.addAttribute("regId", userService.getUserRegId(login.getEmail()));
			HttpSession session = request.getSession();
			session.setAttribute("email",login.getEmail());
			return "redirect:/home";
		}
	}
	@GetMapping("/addVehicle")
	public String addvehicle(@RequestParam("regId") String regId, Model model) {
		model.addAttribute("regId",regId);
		model.addAttribute("vehicle", new Vehicle());
		return "addVehicle";
	}
	@PostMapping("/addVehicle")
	public String vehicleAdded(@Validated Vehicle vehicle,BindingResult result,final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "addVehicle";
		} else {
			Vehicle dbVehicle = DTOUtil.map(vehicle, Vehicle.class);
			vehicleService.addVehicle(dbVehicle);
			redirectAttributes.addAttribute("vehicleType", vehicle.getVehicleType());
			redirectAttributes.addAttribute("regId", vehicle.getRegId());
			return "redirect:/getPass";
		}

	}
	@GetMapping("/getPass")
	public String getPass(@RequestParam("vehicleType")String vehicleType,@RequestParam("regId")String regId,Model model) {
		model.addAttribute("vehicleType", vehicleType);
		model.addAttribute("regId", regId);
		model.addAttribute("pass", new Pass());
		
		return "getPass";
	}
	@PostMapping("/getPass")
	public String passSelected(Pass pass,final RedirectAttributes redirectAttributes, Model model ) {
		Pass dbPass = DTOUtil.map(pass, Pass.class);
		passService.addPass(dbPass);
		redirectAttributes.addAttribute("regId", pass.getRegId());
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(@RequestParam("regId")Integer regId, Model model) {
		EmployeeDetails emp = userService.getEmpDetails(regId);
		model.addAttribute("emp", emp);
		return "home";
	}

	@GetMapping("/friend")
	public String showFriends(FriendForEmp friendForEmp, Model model) {
		List<Friend> listFriend = userService.getFriendList(friendForEmp.getEmpRegId(), friendForEmp.getEmpOrganization());
		model.addAttribute("list", listFriend);
		return "friend";
	}
	
	@GetMapping("/friendProfile")
	public String showFriendProfile(Friend friend, Model model) {
		FriendProfile friendProfile = userService.getFriendProfile(friend.getRegId());
		model.addAttribute("profile", friendProfile);
		return "friendProfile";
	}

	@PostMapping("/update")
	public String updateDetail(EmployeeDetails emp, BindingResult result,Model model) {
		if (userService.updateDetail(emp)) {
			EmployeeDetails employee = userService.getEmpDetails(emp.getRegId());
			model.addAttribute("emp", employee);
			return "home";
		} 
		else{
			return "home";
		}
	}
	
	@GetMapping("/logout")
	public String logOut(HttpServletRequest request){
		HttpSession session= request.getSession(false);
		if(session != null){
			session.invalidate();
		}

		return "redirect:/login";
	}
}
