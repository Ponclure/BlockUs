execute as @a[x=-250,y=201,z=-324,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
clear @a[x=-250,y=201,z=-324,dx=6,dy=3,dz=1] glass
clear @a[x=-250,y=201,z=-324,dx=6,dy=3,dz=1] iron_block

tp @a[x=-250,y=201,z=-324,dx=6,dy=3,dz=1] @e[tag=electrical,tag=calibrate,limit=1]

execute as @e[tag=electrical,tag=calibrate,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/electrical/calibrate
