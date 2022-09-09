package com.example.septchallenge1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeptChallenge1Controller {

    @RequestMapping(path = "/item")
    public Class itemController(){

        @Autowired
        private ItemDAO itemDao;

        @GetMapping(path="/", produces = "application/json")
        public Item getEmployees(@PathVariable String id)
        {
            Item returnItem = new Item();
            boolean found = false;

            for (int i = 0; i < itemDao.getItemsList().getItemList().size() && !found; ++i)
                if (Objects.equals(itemDao.getItemsList().getItemList().get(i).getId(), id)) {
                    returnItem = itemDao.getItemsList().getItemList().get(i);
                    found = true;
                }

            return returnItem;
        }

        @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
        public Item addItem(@RequestBody Item newItem)
        {
            itemDao.addItem(newItem);
            return itemDao.getItemsList().getItemList().get(Integer.parseInt(newItem.getId()));
        }

        @PutMapping(path="/{id}")
        public Item updateItem(@PathVariable String id, @RequestBody Item item)
        {
            return itemDao.updateItem(id, item);
        }

        @DeleteMapping(path = "/{id}")
        public Item deleteItem(@PathVariable String id)
        {
            return itemDao.deleteItem(id);
        }
    }
    }

}
