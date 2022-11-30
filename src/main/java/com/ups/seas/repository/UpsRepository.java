package com.ups.seas.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.seas.exception.EmployeeNotFound;
import com.ups.seas.model.UpsEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

//@Repository
@Slf4j
@Component
public class UpsRepository {

	public UpsEmployee getEmployeeDetails(String employeeId) throws EmployeeNotFound {
		log.info("[UpsRepository][getEmployeeDetails] is called, employeeId: {} ", employeeId);
		UpsEmployee employee = null;
		if (!Objects.isNull(employeeId) && !employeeId.isEmpty()) {
			String response = "{\r\n"
					+ "	\"employeeID\": \"0000054\",\r\n"
					+ "	\"buildingMnemonic\": \"ABEDN\",\r\n"
					+ "	\"firstName\": \"John\",\r\n"
					+ "	\"middleName\": \"A\",\r\n"
					+ "	\"lastName\": \"Doe\",\r\n"
					+ "	\"firstNameAlternative\": \"Jack\",\r\n"
					+ "	\"middleNameAlternative\": \"A\",\r\n"
					+ "	\"lastNameAlternative\": \"Doe\",\r\n"
					+ "	\"primaryPhoneNumber\": \"xxx-xxx-xxxx\",\r\n"
					+ "	\"workPhoneNumber\": \"xxx-xxx-xxxx\",\r\n"
					+ "	\"preferredEmail\": \"jdoe@gmail.com\",\r\n"
					+ "	\"birthDate\": \"mm/dd\",\r\n"
					+ "	\"supervisoryOrganization\": \"\",\r\n"
					+ "	\"jobCode\": \"0072\",\r\n"
					+ "	\"originalHireDate\": \"202203020000EST\",\r\n"
					+ "	\"rehireDate\": \"202203020000EST\",\r\n"
					+ "	\"terminationDate\": \"202203020000EST\",\r\n"
					+ "	\"workerType\": \"EMP\",\r\n"
					+ "	\"homePostalCode\": \"7834\",\r\n"
					+ "	\"homeCountryCode\": \"US\",\r\n"
					+ "	\"unionID\": \"\",\r\n"
					+ "	\"unionType\": \"T\",\r\n"
					+ "	\"employmentStatus\": \"A\",\r\n"
					+ "	\"userProfilePicture\": \"\",\r\n"
					+ "	\"systemIdentifier\": \"G8\",\r\n"
					+ "	\"companyID\": \"228\",\r\n"
					+ "	\"companyName\": \"UPS General Services\",\r\n"
					+ "	\"companyCountry\": \"US\",\r\n"
					+ "	\"departmentID\": \"\",\r\n"
					+ "	\"departmentName\": \"\",\r\n"
					+ "	\"departmentHead\": \"\",\r\n"
					+ "	\"departmentParent\": \"\",\r\n"
					+ "	\"centerCode\": \"0010\",\r\n"
					+ "	\"centerName\": \"\",\r\n"
					+ "	\"jobLevel\": \"77\",\r\n"
					+ "	\"jobLevelName\": \"FT Supervisor\",\r\n"
					+ "	\"jobFunctionCode\": \"CAP\",\r\n"
					+ "	\"jobFunction\": \"Operations\",\r\n"
					+ "	\"regionID\": \"03\",\r\n"
					+ "	\"regionName\": \"AMERICAS\",\r\n"
					+ "	\"districtID\": \"01\",\r\n"
					+ "	\"districtName\": \"North Carolina\",\r\n"
					+ "	\"locationID\": \"FLBAY\",\r\n"
					+ "	\"locationName\": \"Bayside Center\",\r\n"
					+ "	\"locationAddress1\": \"5201 EAGLE TRAIL DRIVE\",\r\n"
					+ "	\"locationAddress2\": \"APT 929\",\r\n"
					+ "	\"locationCity\": \"Tampa\",\r\n"
					+ "	\"locationState\": \"FL\",\r\n"
					+ "	\"locationCountry\": \"US\",\r\n"
					+ "	\"locationDistrictID\": \"\",\r\n"
					+ "	\"locationRegionID\": \"\",\r\n"
					+ "	\"locationPostalCode\": \"33592\",\r\n"
					+ "	\"positionName\": \"\",\r\n"
					+ "	\"fullTimeIndicator\": \"F\",\r\n"
					+ "	\"sortType\": \"0\",\r\n"
					+ "	\"employeeTypeCode\": \"B\",\r\n"
					+ "	\"businessUnit\": \"\",\r\n"
					+ "	\"managerID\": \"0000054\",\r\n"
					+ "	\"workLocationNameHost\": \"\",\r\n"
					+ "	\"workLocationAddress1Host\": \"\",\r\n"
					+ "	\"workLocationAddress2Host\": \"\",\r\n"
					+ "	\"workLocationCityHost\": \"\",\r\n"
					+ "	\"workLocationStateHost\": \"\",\r\n"
					+ "	\"workLocationCountryHost\": \"\",\r\n"
					+ "	\"workLocationNameHome\": \"\",\r\n"
					+ "	\"workLocationAddress1Home\": \"\",\r\n"
					+ "	\"workLocationAddress2Home\": \"\",\r\n"
					+ "	\"workLocationCityHome\": \"\",\r\n"
					+ "	\"workLocationStateHome\": \"\",\r\n"
					+ "	\"workLocationCountryHome\": \"\",\r\n"
					+ "	\"version\": \"0.1.1\"\r\n"
					+ "}";
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				employee = objectMapper.readValue(response, UpsEmployee.class);
			} catch (IOException e) {
				throw new EmployeeNotFound("facing issue in employee data");
			}
		}
		return employee;
	}
}
