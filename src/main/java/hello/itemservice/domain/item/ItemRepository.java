package hello.itemservice.domain.item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    // 상품저장
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    // 상품 조회(아이디)
    public Item findById(Long id) {
        return store.get(id);
    }

    // 상품 목록 조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 상품 수정
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setRegions(updateParam.getRegions());
        findItem.setItemType(updateParam.getItemType());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
    }

    // 상품 삭제
    public void delete(Long itemId) {
        Item findItem = findById(itemId);
        if(findItem != null) {
            store.remove(itemId);
        }
    }

    // 테스트용 초기화
    public void clearStore() {
        store.clear();
    }





}
