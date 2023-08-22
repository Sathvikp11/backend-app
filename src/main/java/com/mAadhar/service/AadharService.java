package com.mAadhar.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mAadhar.bean.Aadhar;
import com.mAadhar.repository.AadharRepository;



@Service
public class AadharService {
	@Autowired
	AadharRepository aadharRepository;
	
	public String storeAadhar(Aadhar aadhar) {
		aadharRepository.save(aadhar);
		return "Aadhar Details Submitted Succesfully";
	}
	public List<Aadhar> getAllAadhar(){
		return aadharRepository.findAll();
	}
	public String findAadharById(int cid) {
		Optional<Aadhar> result = aadharRepository.findById(cid);
		if(result.isPresent()) {
			Aadhar a = result.get();
			return a.toString();
		}else {
			return "Aadhar Details not found";
		}
	}
	public String deleteAadhar(int cid) {
		Optional<Aadhar> result = aadharRepository.findById(cid);
		if(result.isPresent()) {
			Aadhar a = result.get();
			aadharRepository.delete(a);
			return "Aadhar Deleted Succesfully";
		}else {
			return "Aadhar details didn't match with record";
		}
	}
//	public String updateAadhar(Aadhar aadhar) {
//		Optional<Aadhar> result = aadharRepository.findById(aadhar.getCid());
//		if(result.isPresent()) {
//			Aadhar a = result.get();
//			a.setCname(aadhar.getCname());
//			a.setAddress(aadhar.getAddress());
//			a.setDob(aadhar.getDob());
//			a.setEmailid(aadhar.getEmailid());
//			a.setNumber(aadhar.getNumber());
//			aadharRepository.saveAndFlush(a);
//			return "Aadhar Details Updated Succesfully";
//		}else {
//			return "Aadhar details not present";
//		}
//	}
	
	 // Method to update "verified" field in Aadhar entity
    public String updateAadharVerification(int cid, boolean isVerified) {
        Aadhar aadhar = aadharRepository.findById(cid).orElse(null);
        
        if (aadhar != null) {
            aadhar.setVerified(isVerified);
            aadharRepository.save(aadhar);
            if(isVerified) {

                return "Aadhar" +  String.valueOf(cid) + " Verified Successfully !";
            }
            else {
            	 return "Aadhar" +  String.valueOf(cid) + " Verified Status Reset Successfully !";
            }
        } else {
            // Handle the case when the Aadhar entry with the provided "cid" is not found
            throw new IllegalArgumentException("Aadhar entry with cid " + cid + " not found.");
        }
    }
    
    // Method to update "verified" field in Aadhar entity
    public String updateAadharApproval(int cid, boolean isApproved) {
        Aadhar aadhar = aadharRepository.findById(cid).orElse(null);
        
        if (aadhar != null) {
            aadhar.setApproved(isApproved);
            aadharRepository.save(aadhar);
            if(isApproved) {

            	  return "Aadhar" +  String.valueOf(cid) + " Approved !";
            }
            else {
            	 return "Aadhar" +  String.valueOf(cid) + " Approved Status Reset Successfully !";
            }
            
          
        } else {
            // Handle the case when the Aadhar entry with the provided "cid" is not found
            throw new IllegalArgumentException("Aadhar entry with cid " + cid + " not found.");
        }
    }
    
    
public String updateAadhar(Aadhar aadhar) {
    // Mobile number validation: Assuming a 10-digit mobile number is required.
    if (!isValidMobileNumber(aadhar.getNumber())) {
        return "Invalid mobile number. Please enter a 10-digit mobile number.";
    }

    Optional<Aadhar> result = aadharRepository.findById(aadhar.getCid());
    if (result.isPresent()) {
        Aadhar a = result.get();
        a.setCname(aadhar.getCname());
        a.setAddress(aadhar.getAddress());
        a.setDob(aadhar.getDob());
        a.setEmailid(aadhar.getEmailid());
        a.setNumber(aadhar.getNumber());
        
        // For citizens: The home page would authenticate only if the mobile number provided in Aadhaar is matching with the password.
        
        aadharRepository.saveAndFlush(a);
        return "Aadhar Details Updated Successfully";
    } else {
        return "Aadhar details not present";
    }
}

	private boolean isValidMobileNumber(String mobileNumber) {
	    // The mobile number should be exactly 10 digits and contain only digits.
	    return Pattern.matches("\\d{10}", mobileNumber);
	}


}


