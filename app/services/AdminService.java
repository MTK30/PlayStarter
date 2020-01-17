package services;

import models.LoginDetails;
import repositories.LoginDetailsRepository;
import skeletons.exception.TrainCustomException;
import skeletons.request.LoginRegisterDetailsRequest;
import skeletons.request.LoginRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigInteger;
import java.security.MessageDigest;

@Singleton
public class AdminService {

    private LoginDetailsRepository loginDetailsRepository;

    @Inject
    public AdminService(LoginDetailsRepository loginDetailsRepository) {
        this.loginDetailsRepository = loginDetailsRepository;
    }

    public Boolean setLoginCredentials(LoginRegisterDetailsRequest loginDetailsRequest) {
        Boolean isSaved = Boolean.FALSE;
        if(loginDetailsRequest == null) {
            throw new TrainCustomException(500,"Invalid Request","Request is null");
        }
        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setUserName(loginDetailsRequest.getUserName());
        loginDetails.setMobileNo(loginDetailsRequest.getMobileNo());
        String md5Pwd;
        try {
            md5Pwd = getMd5Representation(loginDetailsRequest.getPwd());
            loginDetails.setMd5Pwd(md5Pwd);
        }
        catch (Exception ex) {
            throw new TrainCustomException(500,"Md5 Algo","Error in Genrating the md5 algorithm");
        }
        if(loginDetails.getMd5Pwd()!= null) {
            try {
                loginDetailsRepository.save(loginDetails);
                isSaved = Boolean.TRUE;
            } catch (Exception ex) {
                throw new TrainCustomException(410,"Persistance Call",ex.getMessage());
            }
        }
        return isSaved;
    }

    public Boolean isUser(LoginRequest loginRequest) {
        Boolean isLoggedInUser = Boolean.FALSE;
        try {
            String pwd = getMd5Representation(loginRequest.getPwd());
            LoginDetails loginDetails = loginDetailsRepository.getLoggedInUser(loginRequest.getUserName(),pwd);
            if(loginRequest != null) {
                isLoggedInUser = Boolean.TRUE;
            }
        }
        catch(Exception ex) {
            throw new TrainCustomException(500,"Presistance Exception",ex.getMessage());
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
            throw new TrainCustomException(500,"Invalid algo","ALgorithm MD5 in MessageDigest");
        }
        return md5Pwd;
    }
}
