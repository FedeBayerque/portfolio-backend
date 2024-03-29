package com.portfolio.fb.controller;

import com.portfolio.fb.model.Language;
import com.portfolio.fb.service.ILanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://porfolio-fb.web.app/", "https://fedebayer.web.app/"})
@RestController
@RequestMapping("/languages")
public class LanguageController {
    private final ILanguageService ilanguageServ;

    public LanguageController(ILanguageService ilanguageServ) {
        this.ilanguageServ = ilanguageServ;
    }


    @GetMapping()
    public ResponseEntity<List<Language>> getLanguages() {
        return new ResponseEntity<>(ilanguageServ.getLanguages(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<Language> addLanguage(@RequestBody Language lang) {
        Language newLang = ilanguageServ.addLanguage(lang);
        return new ResponseEntity<>(newLang, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
        return new ResponseEntity<>(ilanguageServ.getLanguageById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLanguageById(@PathVariable Long id) {
        ilanguageServ.deleteLanguageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public ResponseEntity<Language> updateLanguage(@RequestBody Language lang) {
        Language updatedLang = ilanguageServ.updateLanguage(lang);
        return new ResponseEntity<>(updatedLang, HttpStatus.OK);
    }
}
