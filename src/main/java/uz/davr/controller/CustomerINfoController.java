package uz.davr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.davr.dto.ClientId;
import uz.davr.dto.CustomerRevenueDto2;
import uz.davr.dto.EndBeginDate;
import uz.davr.service.CustomerRevenueService;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class CustomerINfoController  {

  private final CustomerRevenueService service;

//  @GetMapping()
//    public  List<CustomerRevenueDto2> getAllClientINfo(){
//     return service.getAllClientId();
//  }

    @GetMapping("/report")
    public ResponseEntity<FileSystemResource> getToReport() throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource(service.getToReport());
        return ResponseEntity.ok()
                .contentLength(fileSystemResource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-disposition", "attachment; filename=" + fileSystemResource.getFilename())
                .body(fileSystemResource);
    }

    @PostMapping("/allList")
    public  ResponseEntity<List<CustomerRevenueDto2>> getListToJsonClients(@RequestBody EndBeginDate endBeginDate) throws IOException {
        return ResponseEntity.ok(service.getAllClientToList(endBeginDate));
    }

    @PostMapping("/getOneClientInfo")
    public CustomerRevenueDto2 getOneClient(@RequestBody ClientId clientId){
        return service.getOneClient(clientId);
    }
}
