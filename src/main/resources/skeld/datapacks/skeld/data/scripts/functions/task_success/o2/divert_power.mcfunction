execute as @a[x=-250,y=201,z=-346,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-250,y=201,z=-346,dx=6,dy=3,dz=1] @e[tag=o2,tag=divert_power,limit=1]

execute as @e[tag=o2,tag=divert_power,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/o2/divert_power