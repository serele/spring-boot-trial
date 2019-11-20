--OBTENER PRECIO Y PRECIO CON DESCUENTO DE LOS ITEMS

select 
	case 
		when i.id in(select item_id from items_price_reductions) 
			then i.price-(i.price * pr.reduced_price)
		else
			i.price
	end
from items i left join items_price_reductions ipr on i.id = ipr.item_id,
		price_reductions pr join items_price_reductions ip on pr.id = ip.price_reductions_id
where CURRENT_TIMESTAMP between pr.start_date and pr.end_date
