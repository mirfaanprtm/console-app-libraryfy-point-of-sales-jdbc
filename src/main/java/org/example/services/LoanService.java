package org.example.services;

import org.example.models.Books;
import org.example.models.Loan;
import org.example.models.Users;
import org.example.repository.ILibraryRepository;
import org.example.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class LoanService implements ILibraryService<Loan>{
    private ILibraryRepository<Loan> loanRepository;

    public LoanService(ILibraryRepository<Loan> loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
        public Loan create(Loan loan) throws Exception {
        try {
            if(loan.getQty() >= 5){
                throw new Exception("Sorry, You've Borrowed More Than Five Books ");
            }
            loanRepository.create(loan);
            System.out.println("Create Loan Success");
            return loan;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Loan> findAll() throws Exception {
        try {
            List<Loan> loans = loanRepository.findAll();
            if(loans.isEmpty()){
                throw new Exception("Data Loan Not Found!");
            }
            return loanRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Loan> findById(String id) throws Exception {
        try {
            List<Loan> loan = loanRepository.findById(id);
            if(loan.isEmpty()){
                throw new Exception("ID Not Found");
            }
            return loanRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            List<Loan> loan = loanRepository.findById(id);
            if(loan.isEmpty()){
                throw new Exception("ID Not Found");
            }
            loanRepository.delete(id);
            System.out.println("Delete Success");
        } catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public void update(Loan loan, String id) throws Exception {
        try {
            List<Loan> loan1 = loanRepository.findById(id);
            if (loan1.isEmpty()) {
                throw new Exception("ID Not Found");
            }
            loanRepository.update(loan, id);
            System.out.println("Update Success");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
