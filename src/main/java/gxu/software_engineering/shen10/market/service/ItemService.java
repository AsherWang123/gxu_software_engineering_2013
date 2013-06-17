package gxu.software_engineering.shen10.market.service;

import gxu.software_engineering.shen10.market.entity.Item;
import gxu.software_engineering.shen10.market.entity.User;

import java.util.List;

public interface ItemService {

	/**
	 * 发布一个新物品。
	 * @return 若创建成功，返回成功创建的，否则抛出异常。
	 */
	public Item create(Item item);

	/**
	 * 修改一个物品。
	 * @return 返回修改成功后的物品，否则抛出异常。
	 */
	public Item modify(Item item);

	/**
	 * 物品所属人将物品标注为关闭状态。
	 * @param user 提出关闭申请的卖家。
	 * @param itemId 想要关闭物品的标识。
	 */
	public void close(User user, long itemId);

	/**
	 * 将已经关闭的物品置为打开状态（可以出售）。
	 */
	public void open(User user, long itemId);

	/**
	 * 查看物品详细说明，若不存在，或者被管理员锁住，则会抛出异常。
	 * @param 物品id标识。
	 */
	public Item detail(long itemId);

	/**
	 * 查看最新的物品列表。
	 */
	public List<Item> latest(int count);

	/**
	 * 查看物品的列表。
	 * @param lastItemId 上一个物品的id，为0表示刷新。
	 */
	public List<Item> list(long lastItemId, int count);

	/**
	 * 返回系统所有的物品数。
	 * @param deal 是否卖出。
	 * @return 若deal为true，那么返回所有的，否则返回待售的。
	 */
	public long size(boolean deal);

	/**
	 * 某个卖家的物品数。
	 * @param deal 是否已经卖出
	 * @return 若deal为true，那么返回所有的，否则返回待售的。
	 */
	public long size(long userId, boolean deal);

	/**
	 * 返回某个卖家的物品。
	 * @param lastItemId 查看更多的物品的偏移量，为0表示刷新。
	 * @return 若deal为true，那么返回的是所有的，否则返回待售的。
	 */
	public List<Item> list(long userId, int count, boolean deal, long lastItemId);

	/**
	 * 返回某个类别下的代售物品。
	 * @param lastItemId 查看更多的物品的偏移量，为0表示刷新。
	 */
	public List<Item> list(long categoryId, int count, long lastItemId);

	/**
	 * 返回某个类别下的待售物品数。
	 */
	public long size(long categoryId);

	/**
	 * 返回最热门的物品列表。
	 */
	public List<Item> hot(int count);

}