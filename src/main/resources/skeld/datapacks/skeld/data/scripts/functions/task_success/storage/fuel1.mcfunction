execute as @a[x=-290,y=201,z=-324,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
clear @a[x=-290,y=201,z=-324,dx=6,dy=3,dz=1] bucket
clear @a[x=-290,y=201,z=-324,dx=6,dy=3,dz=1] water_bucket
tp @a[x=-290,y=201,z=-324,dx=6,dy=3,dz=1] @e[tag=storage,tag=fuel1,limit=1]

execute as @e[tag=storage,tag=fuel1,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/storage/fuel1

execute as @e[tag=task,tag=upper_engine,tag=part2,tag=fuel,limit=1] run function scripts:increment_task
