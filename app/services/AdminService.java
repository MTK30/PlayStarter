package services;

import models.LoginDetails;
import models.User;
import repositories.LoginDetailsRepository;
import repositories.UserRepository;
import skeletons.exception.CareerCarrierException;
import skeletons.request.RegisterUserDetailsRequest;
import skeletons.request.LoginRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

@Singleton
public class AdminService {

    private UserRepository userRepository;
    private LoginDetailsRepository loginDetailsRepository;

    @Inject
    public AdminService(LoginDetailsRepository loginDetailsRepository,UserRepository userRepository) {
        this.loginDetailsRepository = loginDetailsRepository;
        this.userRepository = userRepository;
    }

    public Boolean createUser(RegisterUserDetailsRequest registerUserDetailsRequest) {
        Boolean newUserCreated;
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(registerUserDetailsRequest.getUserName());
        loginRequest.setPwd(registerUserDetailsRequest.getPwd());
        if(isUser(loginRequest)) {
            throw new CareerCarrierException(200,"Existing User","UserName and PWD exist");
        }
        User user = new User();
        user.setName(registerUserDetailsRequest.getName());
        user.setMoblieNo(registerUserDetailsRequest.getMobileNo());
        Long getDate = Long.parseLong(registerUserDetailsRequest.getDob());
        Date dateOfBirth = new Date(getDate * 1000);
        user.setDob(dateOfBirth);
        user.setEducationQualification(registerUserDetailsRequest.getEducationQualification());
        user.setProfessionalPosition(registerUserDetailsRequest.getProfessionalPosition());
        user.setFieldOfExpertise(registerUserDetailsRequest.getFieldOfExpertise());
        user.setAbout(registerUserDetailsRequest.getAboutUser());
        user.setCanAnswer(registerUserDetailsRequest.getCanAnswer());
        try {
            userRepository.save(user);
            newUserCreated = Boolean.TRUE;
        }
        catch (Exception ex) {
            throw new CareerCarrierException(500,"Presistance Exception",ex.getMessage());
        }
        if(newUserCreated) {
            setLoginCredentials(registerUserDetailsRequest,user.getId());
        }
        return newUserCreated;
    }

    public Boolean setLoginCredentials(RegisterUserDetailsRequest loginDetailsRequest, Long userId) {
        Boolean isSaved = Boolean.FALSE;
        if(loginDetailsRequest == null) {
            throw new CareerCarrierException(500,"Invalid Request","Request is null");
        }
        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setUserName(loginDetailsRequest.getUserName());
        loginDetails.setUserId(userId);
        String md5Pwd;
        try {
            md5Pwd = getMd5Representation(loginDetailsRequest.getPwd());
            loginDetails.setMd5Pwd(md5Pwd);
        }
        catch (Exception ex) {
            throw new CareerCarrierException(500,"Md5 Algo","Error in Genrating the md5 algorithm");
        }
        if(loginDetails.getMd5Pwd()!= null) {
            try {
                loginDetailsRepository.save(loginDetails);
                isSaved = Boolean.TRUE;
            } catch (Exception ex) {
                throw new CareerCarrierException(500,"Persistance Call",ex.getMessage());
            }
        }
        return isSaved;
    }

    public Boolean isUser(LoginRequest loginRequest) {
        Boolean isLoggedInUser = Boolean.FALSE;
        try {
            String pwd = getMd5Representation(loginRequest.getPwd());
            LoginDetails loginDetails = loginDetailsRepository.getLoggedInUser(loginRequest.getUserName(),pwd);
            if(loginDetails != null) {
                isLoggedInUser = Boolean.TRUE;
            }
        }
        catch(Exception ex) {
            throw new CareerCarrierException(500,"Presistance Exception",ex.getMessage());
        }
        return isLoggedInUser;
    }

    public String getMd5Representation(String input) {
        String md5Pwd;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger bigInteger = new BigInteger(1, messageDigest);
            md5Pwd = bigInteger.toString(16);
            while (md5Pwd.length() < 32) {
                md5Pwd = "0" + md5Pwd;
            }
        }
        catch (Exception ex) {
            throw new CareerCarrierException(500,"Invalid algo","ALgorithm MD5 in MessageDigest");
        }
        return md5Pwd;
    }
}
