package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if (outsourcedPartRepository.count() == 0) {
            OutsourcedPart part1 = new OutsourcedPart();
            part1.setCompanyName("The Lawnmower Shop");
            part1.setName("Tires");
            part1.setInv(40);
            part1.setPrice(50.0);
            part1.setId(100L);
            part1.setMinInv(10);
            part1.setMaxInv(100);
            outsourcedPartRepository.save(part1);


            OutsourcedPart part2 = new OutsourcedPart();
            part2.setCompanyName("The Lawnmower Shop");
            part2.setName("Mower blades");
            part2.setInv(25);
            part2.setPrice(60.0);
            part2.setId(101L);
            part2.setMinInv(10);
            part1.setMaxInv(100);
            outsourcedPartRepository.save(part2);


            OutsourcedPart part3 = new OutsourcedPart();
            part3.setCompanyName("The Lawnmower Shop");
            part3.setName("Spark plugs");
            part3.setInv(25);
            part3.setPrice(30.0);
            part3.setId(102L);
            part3.setMinInv(10);
            part3.setMaxInv(100);
            outsourcedPartRepository.save(part3);


            OutsourcedPart part4 = new OutsourcedPart();
            part4.setCompanyName("The Lawnmower Shop");
            part4.setName("Belts");
            part4.setInv(50);
            part4.setPrice(20.0);
            part4.setId(103L);
            part4.setMinInv(10);
            part4.setMaxInv(100);
            outsourcedPartRepository.save(part4);


            OutsourcedPart part5 = new OutsourcedPart();
            part5.setCompanyName("The Lawnmower Shop");
            part5.setName("Weed eater strings");
            part5.setInv(50);
            part5.setPrice(20.0);
            part5.setId(104L);
            part5.setMinInv(10);
            part5.setMaxInv(100);
            outsourcedPartRepository.save(part5);

            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();

            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Tires")) {
                    thePart = part;
                    break;
                }
                if (part.getName().equals("Mower blades")) {
                    thePart = part;
                    break;
                }
                if (part.getName().equals("Spark plugs")) {
                    thePart = part;
                    break;
                }
                if (part.getName().equals("Belts")) {
                    thePart = part;
                    break;
                }
                if (part.getName().equals("Weed eater strings")) {
                    thePart = part;
                    break;
                }
            }

            System.out.println(thePart.getCompanyName());
        }

        if (productRepository.count() == 0) {
        Product ridingMower= new Product("Riding mower",1000.0,15);
        Product zeroTurn= new Product("Zero turn",2000.0,15);
        Product pushMower= new Product("Push mower",500.0,15);
        Product weedEater= new Product("Weed eater",250.0,15);
        Product leafBlower= new Product("Leaf blower",150.0,15);
        productRepository.save(ridingMower);
        productRepository.save(zeroTurn);
        productRepository.save(pushMower);
        productRepository.save(weedEater);
        productRepository.save(leafBlower);
}
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

