package lk.ijse.rental.service.impl;

import lk.ijse.rental.dto.CustomDTO;
import lk.ijse.rental.dto.DriverDTO;
import lk.ijse.rental.entity.Driver;
import lk.ijse.rental.entity.User;
import lk.ijse.rental.repo.DriverRepo;
import lk.ijse.rental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {

        Driver driver = new Driver(dto.getUser_Id(), dto.getName(), dto.getContact_No(), dto.getAddress(), dto.getEmail(), dto.getNic_No(), dto.getLicense_No(), "", dto.getDriverAvailability(), new User(dto.getUser().getUser_Id(), dto.getUser().getRole_Type(), dto.getUser().getUser_Name(), dto.getUser().getPassword()));
        System.out.println(driver);
        if (repo.existsById(dto.getUser_Id()))
            throw new RuntimeException("Driver Already Exist. Please enter another id..!");

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            driver.setLicense_Img("uploads/" + dto.getLicense_Img().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);


    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public void deleteDriver(String reg_ID) {

    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getAllAvalabileDriver() {
        return null;
    }

    @Override
    public CustomDTO userIdGenerate() {
        return null;
    }

    @Override
    public CustomDTO getSumAvailableDriver() {
        return null;
    }

    @Override
    public CustomDTO getSumUnavailableDriver() {
        return null;
    }

    @Override
    public Driver searchDriverId(String id) {
        return null;
    }

    @Override
    public CustomDTO getSumDriver() {
        return null;
    }
}
