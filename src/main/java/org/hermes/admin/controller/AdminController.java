package org.hermes.admin.controller;

import com.sun.org.apache.regexp.internal.REUtil;
import org.hermes.admin.bean.DispatchInfo;
import org.hermes.admin.bean.Driver;
import org.hermes.admin.bean.Vehicle;
import org.hermes.admin.bean.WayBill;
import org.hermes.admin.service.AdminService;
import org.hermes.common.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/2/21.
 */
@RequestMapping("admin")
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("ajax/addWayBill")
    @ResponseBody
    public Result addWayBill(@RequestBody WayBill wb){
        return adminService.addWayBill(wb);
    }
    @ResponseBody
    @RequestMapping("ajax/queryWayBill")
    public List<WayBill> queryWayBill(){
        return adminService.queryWayBill();
    }

    @ResponseBody
    @RequestMapping("ajax/getWayBill/{id}")
    public WayBill getWayBillById(@PathVariable String id){
        return adminService.getWayBillById(id);
    }

    @ResponseBody
    @RequestMapping("ajax/getNotOnWayWayBill")
    public List<WayBill> getNotOnWayWayBill(){
        return adminService.getNotOnWayWayBill();
    }

    @ResponseBody
    @RequestMapping("ajax/getAlreadyOnWayWayBill/{dispatchId}")
    public List<WayBill> getAlreadyOnWayWayBill(@PathVariable String dispatchId){
        return adminService.getAlreadyOnWayWayBill(dispatchId);
    }

    @ResponseBody
    @RequestMapping("ajax/deleteWayBill")
    public Result deleteWayBill(@RequestBody Map<String,String> map){
       return adminService.deleteWayBill(map.get("id"));
    }

    @ResponseBody
    @RequestMapping("setWayBillStaffId/{wayBillId}")
    public Result setWayBillStaffId(@PathVariable String wayBillId,@RequestParam String staffId){
        return adminService.setWayBillStaffId(wayBillId,staffId);
    }

    @ResponseBody
    @RequestMapping("ajax/wayBillArrival/{wayBillId}")
    public Result wayBillArrival(@PathVariable String wayBillId){
        adminService.setWayBillArriveTime(wayBillId);
        return adminService.changeWayBillState(wayBillId,"2");
    }

    @ResponseBody
    @RequestMapping("ajax/softDeleteWayBill/{wayBillId}")
    public Result softDeleteWayBill(@PathVariable String wayBillId){
        return adminService.changeWayBillState(wayBillId,"-1");
    }

    @ResponseBody
    @RequestMapping("ajax/addDispatchInfo")
    public Result addDispatchInfo(@RequestBody DispatchInfo dispatchInfo){
        return adminService.addDispatchInfo(dispatchInfo);
    }

    @ResponseBody
    @RequestMapping("ajax/dispatchSend/{dispatchId}")
    public Result dispatchSend(@PathVariable String dispatchId){
        return adminService.changeDispatchInfoState(dispatchId,"1");
    }

    @ResponseBody
    @RequestMapping("ajax/dispatchArrival/{dispatchId}")
    public Result dispatchArrival(@PathVariable String dispatchId){
        return adminService.dispatchArrival(dispatchId);
    }

    @ResponseBody
    @RequestMapping("ajax/getDispatchById/{id}")
    public DispatchInfo getDispatchById(@PathVariable String id){
        return adminService.getDispatchById(id);
    }
    @RequestMapping("ajax/queryDispatchInfo")
    @ResponseBody
    public List<DispatchInfo> queryDispatchInfo(){
        return adminService.queryDispatchInfo();
    }

    @ResponseBody
    @RequestMapping("ajax/addDriver")
    public Result addDriver(@RequestBody Driver driver){
        return adminService.addDriver(driver);
    }
    @ResponseBody
    @RequestMapping("ajax/queryDriver")
    public List<Driver> queryDriver(){
        return adminService.queryDriver();
    }

    @ResponseBody
    @RequestMapping("ajax/queryDriverById/{id}")
    public Driver queryDriverById(@PathVariable String id){
        return adminService.queryDriverById(id);
    }

    @ResponseBody
    @RequestMapping("ajax/deleteDriver")
    public Result deleteDriver(@RequestBody Map<String,String> map){
        return adminService.deleteDriver(map.get("id"));
    }

    @ResponseBody
    @RequestMapping("ajax/updateDriver")
    public Result updateDriver(@RequestBody Driver driver){
        return adminService.updateDriver(driver);
    }
    @ResponseBody
    @RequestMapping("ajax/addVehicle")
    public Result addVehicle(@RequestBody Vehicle vehicle){
        return adminService.addVehicle(vehicle);
    }

    @ResponseBody
    @RequestMapping("ajax/queryVehicle")
    public List<Vehicle> queryVehicle(){
        return adminService.queryVehicle();
    }

    @ResponseBody
    @RequestMapping("ajax/queryVehicleById/{id}")
    public Vehicle queryVehicleById(@PathVariable String id){
        return adminService.queryVehicleById(id);
    }

    @ResponseBody
    @RequestMapping("ajax/deleteVehicle")
    public Result deleteVehicleInfo(@RequestBody Map<String,String> params){
        System.out.println(params);
        return adminService.deleteVehicleInfo(params.get("id"));
    }
    @ResponseBody
    @RequestMapping("ajax/updateVehicle")
    public Result updateVehicleInfo(@RequestBody Vehicle vehicle){
        return adminService.updateVehicleInfo(vehicle);
    }


    //可删
    @ResponseBody
    @RequestMapping("ajax/updateVehicleState/{vehicleId}")
    public Result updateVehicleState(@PathVariable String vehicleId,@RequestParam String state){
        return adminService.updateVehicleState(vehicleId,state);
    }


    @ResponseBody
    @RequestMapping("ajax/addToJourneyRecord/{dispatchId}")
    public Result addToJourneyRecord(@PathVariable String dispatchId,@RequestParam String str){
        return adminService.addToJourneyRecord(str,dispatchId);
    }

    @ResponseBody
    @RequestMapping("ajax/deleteWayBillsFromJourneyRecord/{dispatchId}")
    public Result deleteWayBillsFromJourneyRecord(@PathVariable String dispatchId,@RequestParam String str){
        return adminService.deleteWayBillsFromJourneyRecord(str,dispatchId);
    }

    @ResponseBody
    @RequestMapping("ajax/getJourneyRecordByWayBillId/{wayBillId}")
    public List<DispatchInfo> getJourneyRecordByWayBillId(@PathVariable String wayBillId){
        return adminService.getJourneyRecordByWayBillId(wayBillId);
    }

    @RequestMapping("addWayBill")
    public String gotoAddWayBill(){
        return "admin/addWayBill";
    }

    @RequestMapping("manageWayBill")
    public String gotoManageWayBill(){
        return "admin/manageWayBill";
    }

    @RequestMapping("wayBillList")
    public String gotoWayBillList(){
        return "admin/wayBillList";
    }

    @RequestMapping("manageVehicle")
    public String gotoManageVehicle(){
        return "admin/manageVehicle";
    }

    @RequestMapping("manageDriver")
    public String gotoManageDriver(){
        return "admin/manageDriver";
    }

    @RequestMapping("manageDispatch")
    public String gotoManageDispatch(){
        return "admin/manageDispatch";
    }

    @RequestMapping("addDispatch")
    public String gotoAddDispatch(){
        return "admin/addDispatch";
    }

    @RequestMapping("dispatch/list")
    public String gotoDispatchList(){
        return "admin/dispatchList";
    }

    @RequestMapping("dispatch/detail")
    public String gotoDispatchDetail(){
        return "admin/dispatchDetail";
    }

    @RequestMapping("waybill/detail")
    public String gotoWayBillDetail(){
        return "admin/waybillDetail";
    }

}
