package demo_springjwt.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import demo_springjwt.demo.dto.Book;
import demo_springjwt.demo.dto.User;
import demo_springjwt.demo.entity.BookEntity;
import demo_springjwt.demo.exception.ExpiredException;
import demo_springjwt.demo.repository.BookRepository;
import demo_springjwt.demo.service.BookStorageService;

@RestController
@RequestMapping("/api/book")
public class BookController extends BaseController{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookStorageService 	bookStorageService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadBook(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws ExpiredException {
		Optional<User> user = this.getCurrentUser();
		if(user.isEmpty()) {
			return ResponseEntity.badRequest().body("Token expired");
		}
		String fileName = this.bookStorageService.saveFile(file);
		if(name != null) {
			BookEntity book = new BookEntity();
			book.setName(name);
			book.setCreatedBy(user.get().getId());
			book.setPath(fileName);
			bookRepository.save(book);
			return ResponseEntity.ok(Book.toDto(book));
		}
		return ResponseEntity.badRequest().body("Book upload failed!");
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> loadBook(@PathVariable("id") Long id) throws IOException {
//		Optional<BookEntity> book = this.bookRepository.findById(id);
//		if(book.isEmpty()) {
//			return ResponseEntity.badRequest().body("Book does not exist!");
//		}
//		File file = this.bookStorageService.loadFile(book.get().getPath());
//		 if (file == null) {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//		 
//		 HttpHeaders headers = new HttpHeaders();
//		 
////		 headers.add("Content-Disposition", "inline;filename=PDF.pdf");
//		 headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=PDF.pdf");
//
//	     InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//	     return ResponseEntity.ok()
//	               .headers(headers)
//	               .contentLength(file.length())
//	               .contentType(MediaType.parseMediaType("application/pdf"))
//	               .body(resource);
//	}
//	
}
