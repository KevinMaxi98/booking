package com.example.bookin.service.impl;

import com.example.bookin.entity.BillboardEntity;
import com.example.bookin.repository.BillboardRepository;
import com.example.bookin.service.BillboardService;
import com.example.bookin.service.dto.BillboardDto;
import com.example.bookin.service.mapper.BillboardMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BillboardServiceImpl implements BillboardService {

    private BillboardRepository billboardRepository;

    @Override
    public List<BillboardDto> getAllBillboard() {
        return billboardRepository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public BillboardDto getBillboardById(Integer id) {
        return entityToDto(billboardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Billboard not found id: " + id)));
    }

    @Override
    public BillboardDto createBillboard(BillboardDto billboardDto) {
        BillboardEntity billboard = billboardRepository.save(dtoToEntity(billboardDto));
        return entityToDto(billboard);
    }

    @Override
    public BillboardDto updateBillboard(Integer id, BillboardDto billboardDto) {
        if (getBillboardById(id) == null) {
            throw new NoSuchElementException("Billboard not found id: " + id);
        }
        BillboardEntity billboard = billboardRepository.save(dtoToEntity(billboardDto));
        return entityToDto(billboard);
    }

    @Override
    public void deleteBillboard(Integer id) {
        billboardRepository.deleteById(id);
    }

    private BillboardDto entityToDto(BillboardEntity billboardEntity) {
        return BillboardDto.builder()
                .id(billboardEntity.getId())
                .status(billboardEntity.getStatus())
                .date(billboardEntity.getDate())
                .endTime(billboardEntity.getEndTime())
                .startTime(billboardEntity.getStartTime())
                .build();
    }

    private BillboardEntity dtoToEntity(BillboardDto billboardDto) {
        return BillboardEntity.builder()
                .id(billboardDto.getId())
                .status(billboardDto.getStatus())
                .date(billboardDto.getDate())
                .endTime(billboardDto.getEndTime())
                .startTime(billboardDto.getStartTime())
                .build();
    }



}
