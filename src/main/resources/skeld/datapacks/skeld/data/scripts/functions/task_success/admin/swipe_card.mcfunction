execute as @a[x=-260,y=201,z=-335,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-260,y=201,z=-335,dx=6,dy=3,dz=1] @e[tag=admin,tag=swipe_card,limit=1]

execute as @e[tag=admin,tag=swipe_card,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/admin/swipe_card

