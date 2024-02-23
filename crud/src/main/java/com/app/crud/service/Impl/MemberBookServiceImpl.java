package com.app.crud.service.Impl;

import com.app.crud.model.memberBook.MemberBook;
import com.app.crud.repository.MemberBookRepository;
import com.app.crud.service.MemberBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberBookServiceImpl implements MemberBookService {
    private final MemberBookRepository memberBookRepository;

    @Autowired
    public MemberBookServiceImpl(MemberBookRepository memberBookRepository) {
        this.memberBookRepository = memberBookRepository;
    }

    public MemberBook getById(String ID) {
        return memberBookRepository.getById(ID);
    }

    public List<MemberBook> getMemberBooks() {
        return memberBookRepository.findAll();
    }

    public List<MemberBook> getByMember_id(String member_id) {
        return memberBookRepository.getByMember_id(member_id);
    }

    public List<MemberBook> getByISBN(String ISBN) {
        return memberBookRepository.getByISBN(ISBN);
    }

    public List<MemberBook> getByLoan_ID(String loan_ID) {
        return memberBookRepository.getByLoan_id(loan_ID);
    }

    @Override
    public List<MemberBook> getByAmount(int amount) {
        return memberBookRepository.getByAmount(amount);
    }

    public ResponseEntity<Object> createMemberBook(MemberBook memberBook) {
        HashMap<String, Object> message = new HashMap<>();

        try {
            memberBookRepository.save(memberBook);
            message.put("success", memberBook);

            return new ResponseEntity<>(
                    message,
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            message.put("error", true);
            message.put("message", e.getMessage());
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }
    }
}
