package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.*;
import com.gym.lbdgym.model.lesson.Lesson;
import com.gym.lbdgym.model.lesson.LessonAvailable;
import com.gym.lbdgym.model.room.EquipmentRoom;
import com.gym.lbdgym.model.room.LessonRoom;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.service.*;
import com.gym.lbdgym.service.lesson.LessonAvailableService;
import com.gym.lbdgym.service.room.EquipmentRoomService;
import com.gym.lbdgym.service.room.LessonRoomService;
import com.gym.lbdgym.service.room.SquashRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;
import java.util.stream.LongStream;

import static com.gym.lbdgym.model.enumerator.Schooling.COLLEGE;
import static com.gym.lbdgym.model.enumerator.State.GOOD;
import static com.gym.lbdgym.model.enumerator.State.VERY_BAD;

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

    @GetMapping
    public ResponseEntity<?> populating() {

        LongStream.range(0, 20000).forEach(i -> {
            Associate associate = createAssociate();
            SquashRoom squashRoom = createSquashRoom();
            LessonRoom lessonRoom = createLessonRoom();
            EquipmentRoom equipmentRoom = createEquipmentRom();
            BankingData bankingData = createBankingData();
            Monitor monitor = createMonitor();
            Equipment equipment = createEquipment(equipmentRoom);
            LessonAvailable lessonAvailable = createLessonAvailable(monitor, lessonRoom);
            Booking booking = createBooking(associate, squashRoom);
            CanTeach canTeach = createCanTeach(lessonAvailable, monitor);
            Enrollment enrollment = createEnrollment(associate, lessonAvailable);

            associateService.save(associate);
            squashRoomService.save(squashRoom);
            lessonRoomService.save(lessonRoom);
            equipmentRoomService.save(equipmentRoom);
            bankingDataService.save(bankingData);
            monitorService.save(monitor);
            equipmentService.save(equipment);
            lessonAvailableService.save(lessonAvailable);
            bookingService.save(booking);
            canTeachService.save(canTeach);
            enrollmentService.save(enrollment);
        });
        return ResponseEntity.ok().build();
    }

    public Associate createAssociate() {
        String randomString = UUID.randomUUID().toString();

        Associate associate = new Associate();
        associate.setName(randomString.substring(0, 5));
        associate.setAddress(randomString.substring(5, 10));
        associate.setProfession(randomString.substring(10, 15));
        associate.setPhone(randomString.substring(0, 9));
        return associate;
    }

    public BankingData createBankingData() {
        String randomString = UUID.randomUUID().toString();

        BankingData bankingData = new BankingData();
        bankingData.setAccount(randomString.substring(0, 5));
        bankingData.setAgency(randomString.substring(5, 10));
        return bankingData;
    }

    public Booking createBooking(Associate associate, SquashRoom squashRoom) {
        LocalDateTime start = LocalDateTime.of(LocalDate.of(1970, Month.JANUARY, 1), LocalTime.of(0, 0, 0));
        long days = ChronoUnit.DAYS.between(start, LocalDateTime.now());
        LocalDateTime randomStartDate = start.plusDays(new Random().nextInt((int) days + 1));
        LocalDateTime randomEndDate = randomStartDate.plusHours(2);

        Booking booking = new Booking();
        booking.setAssociate(associate);
        booking.setSquashRoom(squashRoom);
        booking.setStartDate(randomStartDate);
        booking.setEndDate(randomEndDate);
        return booking;
    }

    public CanTeach createCanTeach(Lesson lesson, Monitor monitor) {
        CanTeach canTeach = new CanTeach();
        canTeach.setLesson(lesson);
        canTeach.setMonitor(monitor);
        return canTeach;
    }

    public Enrollment createEnrollment(Associate associate, LessonAvailable lessonAvailable) {
        Enrollment enrollment = new Enrollment();
        enrollment.setAssociate(associate);
        enrollment.setLessonAvailable(lessonAvailable);
        return enrollment;
    }

    public Equipment createEquipment(EquipmentRoom equipmentRoom) {
        Equipment equipment = new Equipment();
        equipment.setConservationState(GOOD);
        equipment.setEquipmentRoom(equipmentRoom);
        equipment.setDescription(UUID.randomUUID().toString().substring(0, 15));
        return equipment;
    }

    public Monitor createMonitor() {
        String randomString = UUID.randomUUID().toString();

        Monitor monitor = new Monitor();
        monitor.setName(randomString.substring(0, 10));
        monitor.setRg(randomString.substring(10, 20));
        monitor.setSchooling(COLLEGE);
        return monitor;
    }

    public EquipmentRoom createEquipmentRom() {
        Random random = new Random();

        EquipmentRoom equipmentRoom = new EquipmentRoom();
        equipmentRoom.setMaxNumberEquipments(random.nextInt(2));
        return equipmentRoom;
    }

    public LessonRoom createLessonRoom() {
        Random random = new Random();

        LessonRoom lessonRoom = new LessonRoom();
        lessonRoom.setMaxNumberAssociates(random.nextInt(2));
        return lessonRoom;
    }

    public SquashRoom createSquashRoom() {
        SquashRoom squashRoom = new SquashRoom();
        squashRoom.setConservationState(VERY_BAD);
        return squashRoom;
    }

    public LessonAvailable createLessonAvailable(Monitor monitor, LessonRoom lessonRoom) {
        LocalDateTime start = LocalDateTime.of(LocalDate.of(1970, Month.JANUARY, 1), LocalTime.of(0, 0, 0));
        long days = ChronoUnit.DAYS.between(start, LocalDateTime.now());
        LocalDateTime randomDate = start.plusDays(new Random().nextInt((int) days + 1));

        LessonAvailable lessonAvailable = new LessonAvailable();
        lessonAvailable.setMonitor(monitor);
        lessonAvailable.setLessonRoom(lessonRoom);
        lessonAvailable.setDescription(UUID.randomUUID().toString().substring(0, 15));
        lessonAvailable.setDateTime(randomDate);
        return lessonAvailable;
    }
}
