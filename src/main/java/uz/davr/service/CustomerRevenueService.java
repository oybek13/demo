package uz.davr.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import uz.davr.dto.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Service
public class CustomerRevenueService {
    private final RestTemplate restTemplate;
    private static final Logger logger = LogManager.getLogger(CustomerRevenueService.class);

    public CustomerRevenueService(RestTemplate restTemplate, List<CustomerRevenueDto2> revenueDto2List) {
        this.restTemplate = restTemplate;
        this.revenueDto2List = revenueDto2List;
    }

    private final List<CustomerRevenueDto2> revenueDto2List;

    public List<CustomerRevenueDto2> getAllClientId(EndBeginDate endBeginDate) throws IOException {
        CallType callType = new CallType();
        callType.setCALL_TYPE("1");
        HttpEntity<CallType> http = new HttpEntity<>(callType, httpHeaders());
        String idClients = restTemplate.exchange("http://172.16.100.110:8080/back/v2/AllClientsJ",
                HttpMethod.POST, http, String.class).getBody();
        logger.warn(idClients);
//        List<IdClient> idClients = null;
//        try {
//            idClients = List.of(restTemplate.exchange("http://172.16.100.110:8080/back/v2/AllClientsJ",
//                    HttpMethod.POST, http, IdClient[].class).getBody());
//        } catch (RestClientException e) {
//            logger.warn(e.getLocalizedMessage());
//        }
//        System.out.println("Size: " + idClients.size());
//        List<CustomerRevenueDto2> customerRevenueDto2s = new ArrayList<>();
//        int i = 0;
//        List<IdClient> errors = new ArrayList<>();
//        for (IdClient idClient : idClients) {
//            i++;
//            try {
//                CustomerRevenueDto2 customerRevenueDto2 = response(idClient, endBeginDate);
//                if (customerRevenueDto2 != null) {
//                    customerRevenueDto2s.add(customerRevenueDto2);
//                }
//                try {
//                    TimeUnit.MILLISECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            } catch (RestClientException e) {
//                errors.add(idClient);
//            }
//            if (i > 30000) {
//                break;
//            }
//        }
//        System.out.println("Error size: " + errors.size());
//
//
//        for (IdClient idClient : errors) {
//            try {
//                CustomerRevenueDto2 customerRevenueDto2 = response(idClient, endBeginDate);
//                if (customerRevenueDto2 != null) {
//                    customerRevenueDto2s.add(customerRevenueDto2);
//                }
//                try {
//                    TimeUnit.MILLISECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            } catch (RestClientException e) {
//                System.out.println("2-etap");
//            }
//        }
//        revenueDto2List.addAll(customerRevenueDto2s);
        return null;
    }

    private CustomerRevenueDto2 response(IdClient idClient, EndBeginDate endBeginDate) throws RestClientException {
        ResponseEntity<CustomerRevenueDto2[]> response;
        HttpEntity<ClientIncomeRequest> http = null;
//        try {
        ClientIncomeRequest clientIncomeRequest = new ClientIncomeRequest(
                idClient.getBranch(), "", "", idClient.getId_client()
        );
        http = new HttpEntity<>(clientIncomeRequest, httpHeaders());
        response = restTemplate.exchange("http://172.16.100.110:8080/back/v2/Clientsincome", HttpMethod.POST, http, CustomerRevenueDto2[].class);
        return Arrays.stream(response.getBody()).findFirst().get();
//        }catch (RestClientException m){
//            System.out.println(idClient.getId_client());
//            System.out.println(restTemplate.exchange("http://172.25.25.200:8080/back/v2/Clientsincome", HttpMethod.POST, http, String.class).getBody());
//            return null;
//        }

    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", "bank981");
        headers.set("password", "Bank00981");
        headers.set("branch", "bank981");
        return headers;
    }

    public File report(List<CustomerRevenueDto2> customerRevenueDto2s) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet0 = workbook.createSheet("Test");
        CellStyle cellStyle = workbook.createCellStyle();

        Row row0 = sheet0.createRow(0);
        Cell cell0 = row0.createCell(0);
        cell0.setCellValue("МФО: 09051");

        Row row1 = sheet0.createRow(1);
        Cell cell10 = row1.createCell(0);
        cell10.setCellValue("Давр банк ГО");

        Row row3 = sheet0.createRow(3);
        Cell cell30 = row3.createCell(0);
        cell30.setCellValue("Доходы по клиентам  с 01.05.2022 по 31.05.2022");
        int x = 8;

        Row row8 = sheet0.createRow(x);
        Cell cell80 = row8.createCell(0);
        cell80.setCellValue("Уник.код");

        Cell cell81 = row8.createCell(1);
        cell81.setCellValue("Дата открытия\n");

        Cell cell82 = row8.createCell(2);
        cell82.setCellValue("наименование\n");

        Cell cell83 = row8.createCell(3);
        cell83.setCellValue("Номер налоговой регистрации");

        Cell cell84 = row8.createCell(4);
        cell84.setCellValue("Филиал");

        Cell cell85 = row8.createCell(5);
        cell85.setCellValue("Сцепить");

        Cell cell86 = row8.createCell(6);
        cell86.setCellValue("Сотрудник");

        Cell cell87 = row8.createCell(7);
        cell87.setCellValue("тариф");

        Cell cell88 = row8.createCell(8);
        cell88.setCellValue("старше 90 дней");

        Cell cell89 = row8.createCell(9);
        cell89.setCellValue("валютдоход");

        Cell cell810 = row8.createCell(10);
        cell810.setCellValue("сумдоход\n");

        Cell cell811 = row8.createCell(11);
        cell811.setCellValue("дебетдоход");

        Cell cell812 = row8.createCell(12);
        cell812.setCellValue("кассадоход");

        Cell cell813 = row8.createCell(13);
        cell813.setCellValue("дист.услуги\n");

        Cell cell814 = row8.createCell(14);
        cell814.setCellValue("Интернетбанк");

        Cell cell815 = row8.createCell(15);
        cell815.setCellValue("Интернетбанк");

        x++;

        for (int i = 0; i < customerRevenueDto2s.size(); i++) {
            CustomerRevenueDto2 customerRevenueDto2 = customerRevenueDto2s.get(i);
            Row row = sheet0.createRow(x + i);

            Cell cell90 = row.createCell(0);
            cell90.setCellValue(customerRevenueDto2.getIdClient());

            Cell cell91 = row.createCell(1);
            cell91.setCellValue(customerRevenueDto2.getDateOpen());

            Cell cell92 = row.createCell(2);
            cell92.setCellValue(customerRevenueDto2.getName());

            Cell cell93 = row.createCell(3);
            cell93.setCellValue(customerRevenueDto2.getInnPinfl());

            Cell cell94 = row.createCell(4);
            cell94.setCellValue(customerRevenueDto2.getBranch());

            Cell cell95 = row.createCell(5);
            cell95.setCellValue(customerRevenueDto2.getBranch() + customerRevenueDto2.getIdClient());

            Cell cell96 = row.createCell(6);
            cell96.setCellValue(customerRevenueDto2.getManager());

            Cell cell97 = row.createCell(7);
            cell97.setCellValue(customerRevenueDto2.getRate());

            Cell cell98 = row.createCell(8);
            cell98.setCellValue(customerRevenueDto2.getCdo());

            Cell cell99 = row.createCell(9);
            cell99.setCellValue(customerRevenueDto2.getDoxodVal());

            Cell cell910 = row.createCell(10);
            cell910.setCellValue(customerRevenueDto2.getDoxodSum());

            Cell cell911 = row.createCell(11);
            cell911.setCellValue(customerRevenueDto2.getDoxodVal());

            Cell cell912 = row.createCell(12);
            cell912.setCellValue(customerRevenueDto2.getDoxodKassa());

            Cell cell913 = row.createCell(13);
            cell913.setCellValue("Уник.код");

            Cell cell914 = row.createCell(14);
            cell914.setCellValue(customerRevenueDto2.getIbk());

            Cell cell915 = row.createCell(15);
            cell915.setCellValue(customerRevenueDto2.getMbk());
        }


        for (int i = 0; i < 16; i++) {
            sheet0.autoSizeColumn(i);
        }


        File file0 = File.createTempFile("report", ".xlsx");
        FileOutputStream resource = new FileOutputStream(file0);
        workbook.write(resource);
        workbook.close();
        resource.close();
        return file0;


    }

    public List<CustomerRevenueDto2> getAllClientToList(EndBeginDate endBeginDate) throws IOException {
        return getAllClientId(endBeginDate);
    }

    public File getToReport() throws IOException {
        return report(revenueDto2List);
    }

    public CustomerRevenueDto2 getOneClient(ClientId clientId) {
        HttpEntity<ClientId> http = null;
        http = new HttpEntity<>(clientId, httpHeaders());
        ResponseEntity<CustomerRevenueDto2[]> exchange = null;
        try {
            exchange = restTemplate.exchange("http://172.16.100.110:8080/back/v2/Clientsincome", HttpMethod.POST, http, CustomerRevenueDto2[].class);

        } catch (Exception e) {
            exchange = null;
        }
        if (exchange != null) {
            return Arrays.stream(Objects.requireNonNull(exchange.getBody())).findFirst().get();
        } else {
            return null;
        }

    }
}
