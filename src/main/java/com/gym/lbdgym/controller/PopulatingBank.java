package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.*;
import com.gym.lbdgym.model.lesson.Lesson;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import com.gym.lbdgym.model.room.EquipmentRoom;
import com.gym.lbdgym.model.room.LessonRoom;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.service.*;
import com.gym.lbdgym.service.lesson.LessonAvailableService;
import com.gym.lbdgym.service.lesson.LessonService;
import com.gym.lbdgym.service.room.EquipmentRoomService;
import com.gym.lbdgym.service.room.LessonRoomService;
import com.gym.lbdgym.service.room.SquashRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.gym.lbdgym.model.enumerator.Schooling.COLLEGE;

@RestController
@RequestMapping({ "/populatingBank" })
@RequiredArgsConstructor
public class PopulatingBank {

    private final AssociateService associateService;
    private final BankingDataService bankingDataService;
    private final BookingService bookingService;
    private final CanTeachService canTeachService;
    private final EnrollmentService enrollmentService;
    private final EquipmentService equipmentService;
    private final MonitorService monitorService;
    private final EquipmentRoomService equipmentRoomService;
    private final LessonRoomService lessonRoomService;
    private final SquashRoomService squashRoomService;
    private final LessonAvailableService lessonAvailableService;
    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<?> populating (){

        IntStream.range(0, 10).forEach(i -> {
            associateService.save(createAssociate((long) i));
            bankingDataService.save(createBankingData((long) i));
            bookingService.save(createBooking((long) i));
            canTeachService.save(createCanTeach((long) i));
            enrollmentService.save(createEnrollment((long) i));
            equipmentService.save(createEquipment((long) i));
            monitorService.save(createMonitor((long) i));
            equipmentRoomService.save(createEquipmentRom());
            lessonRoomService.save(createLessonRoom());
            squashRoomService.save(createSquashRoom());
            lessonAvailableService.save(createLessonAvailable());
            lessonService.save(createLesson((long) i));
        });
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    public static String createName(int amount) {
        StringBuilder builder = new StringBuilder();
        while (amount != 0) {
            String letters = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
            int character = (int) (Math.random() * letters.length());
            builder.append(letters.charAt(character));
            amount--;
        }
        return builder.toString();
    }

    public Associate createAssociate(Long id){
        Associate associate = new Associate();
        associate.setId(id);
        associate.setName(createName(10));
        associate.setAddress(UUID.randomUUID().toString().substring(0,10));
        associate.setProfession(UUID.randomUUID().toString().substring(0,15));
        associate.setPhone(UUID.randomUUID().toString().substring(0,3));
        return associate;
    }

    public BankingData createBankingData(Long id){
        BankingData bankingData = new BankingData();
        bankingData.setId(id);
        bankingData.setAccount(UUID.randomUUID().toString().substring(0,5));
        bankingData.setAgency(UUID.randomUUID().toString().substring(0,10));
        return bankingData;
    }

    public Booking createBooking(Long id){
        Random random = new Random();
        Booking booking = new Booking();
        booking.setId(id);
        booking.setStartDate(LocalDateTime.MIN);
        booking.setStartDate(LocalDateTime.MAX);
        //falta coisa, mudar o horario e criar socio
        return booking;
    }

    public CanTeach createCanTeach(Long id){
        CanTeach canTeach = new CanTeach();
        canTeach.setId(id);
        return canTeach;
    }

    public Enrollment createEnrollment(Long id){
        Enrollment enrollment = new Enrollment();
        enrollment.setId(id);
        return enrollment;
    }

    public Equipment createEquipment(Long id){
        Equipment equipment = new Equipment();
        equipment.setId(id);
        return equipment;
    }

    public Monitor createMonitor(Long id){
        Monitor monitor = new Monitor();
        monitor.setId(id);
        monitor.setName(createName(10));
        monitor.setSchooling(COLLEGE);
        monitor.setRg(UUID.randomUUID().toString().substring(0,10));
        return monitor;
    }

    public EquipmentRoom createEquipmentRom(){
        EquipmentRoom equipmentRoom = new EquipmentRoom();
        return equipmentRoom;
    }

    public LessonRoom createLessonRoom(){
        LessonRoom lessonRoom = new LessonRoom();
        return lessonRoom;
    }

    public SquashRoom createSquashRoom(){
        SquashRoom squashRoom = new SquashRoom();
        return squashRoom;
    }

    public LessonAvailable createLessonAvailable(){
        LessonAvailable lessonAvailable = new LessonAvailable();
        return lessonAvailable;
    }

    public Lesson createLesson(Long id){
        Lesson lesson = new Lesson();
        lesson.setId(id);
        return lesson;
    }

}
